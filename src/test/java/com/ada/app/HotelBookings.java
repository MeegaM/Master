package com.ada.app;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelBookings {
public static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Meega\\eclipse-workspace\\Java\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys(HotelApp.readProp("username"));    // UserName
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(HotelApp.readProp("password"));    //Password
	    driver.findElement(By.xpath("//input[@name='login']")).click();                                       //loginbtn
	    driver.findElement(By.id("location")).sendKeys(HotelApp.excelRead(1,0));                              //Location
	    driver.findElement(By.id("hotels")).sendKeys(HotelApp.excelRead(1,1));                                //Hotels
	    driver.findElement(By.id("room_type")).sendKeys(HotelApp.excelRead(1,2));                             //RoomType
	    driver.findElement(By.id("room_nos")).sendKeys(HotelApp.excelRead(1,3));                              //NumberOfRooms
	    driver.findElement(By.id("datepick_in")).sendKeys(HotelApp.excelRead(1,4));                           //CheckInDate
	    driver.findElement(By.id("datepick_out")).sendKeys(HotelApp.excelRead(1,5));                          //CheckOutDate
	    driver.findElement(By.id("adult_room")).sendKeys(HotelApp.excelRead(1,6));                            //Adult Room
	    driver.findElement(By.id("child_room")).sendKeys(HotelApp.excelRead(1,7));                            //Children Room
	    driver.findElement(By.id("Submit")).submit();
	    driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	    driver.findElement(By.id("radiobutton_0")).click();
	    driver.findElement(By.id("continue")).click();                                                         
	    driver.findElement(By.id("first_name")).sendKeys(HotelApp.excelRead(1,8));                             //First Name
	    driver.findElement(By.id("last_name")).sendKeys(HotelApp.excelRead(1,9));                              //Last Name
	    driver.findElement(By.id("address")).sendKeys(HotelApp.excelRead(1,10));                               //Address
	    driver.findElement(By.id("cc_num")).sendKeys(HotelApp.excelRead(1,11));                                //Credit Card Number
	    driver.findElement(By.id("cc_type")).sendKeys(HotelApp.excelRead(1,12));                               //Credit Card Type
	    driver.findElement(By.id("cc_exp_month")).sendKeys(HotelApp.excelRead(1,13));                          //Expiry Month
	    driver.findElement(By.id("cc_exp_year")).sendKeys(HotelApp.excelRead(1,14));                           //Expiry Year
	    driver.findElement(By.id("cc_cvv")).sendKeys(HotelApp.excelRead(1,15));                                //CVV
	    driver.findElement(By.id("book_now")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    WebElement orderId = driver.findElement(By.xpath("//*[@id='order_no']"));
	    String ordId = orderId.getAttribute("value");
	    System.out.println(ordId);
	    HotelApp.excelwrite(1, 0 ,ordId);
	
	}	
}

