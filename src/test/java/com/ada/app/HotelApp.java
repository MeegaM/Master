package com.ada.app;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelApp {
	//Excel Read
		public static String excelRead(int r, int c) {
			String value = null;
			try {
				File f = new File("C:\\Eclipse\\Projects\\Adactin\\src\\test\\resources\\TestData\\TestData_Excel.xlsx");
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis);
				Sheet sheet = wb.getSheet("Sheet1");
				// excel row size
				Row row = sheet.getRow(r);
				Cell cell = row.getCell(c);
				// System.out.println(cell);
				// to identify the testdata type
				int cellType = cell.getCellType();
				if (cellType == 1) {
					 value = cell.getStringCellValue();
					System.out.println(value);
					// date and number seprate
				} else if (cellType == 0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat sc = new SimpleDateFormat("dd/mm/yyyy");
						 value = sc.format(dateCellValue);
						System.out.println(value);
					} else {
						double numericCellValue = cell.getNumericCellValue();
						long l = (long) numericCellValue;
					 value = String.valueOf(l);
						System.out.println(value);

					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return value;
		}
		
		//Prop Read
		public static String readProp(String value) {
			String data = null;
			try {
				File f = new File("C:\\Eclipse\\Projects\\Adactin\\src\\test\\resources\\TestData\\Test.Properties");
				FileReader read = new FileReader(f);
				Properties prop = new Properties();
				prop.load(read);
				data = (String) prop.getProperty(value);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		}
		
		//Excel Write
		public static String excelwrite(int m,int n ,String num) {

			try {
				File f = new File("C:\\Eclipse\\Projects\\Adactin\\src\\test\\resources\\TestData\\TestData_Excel.xlsx");
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis);
				Sheet cs = wb.createSheet("Order_No");
				Row cr = cs.createRow(m);
				Cell cc = cr.createCell(n);
				cc.setCellValue(num);
				FileOutputStream fos = new FileOutputStream(f);
				wb.write(fos);
				wb.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return num;
		}

	}


