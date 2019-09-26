package com.alphasense.Testautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Utils {
	public static WebDriver driver = null;
	public static Properties prop = new Properties();
	public static ChromeOptions chromeOptions;
	public static String pathToScreenshot;
	
public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
	//String sBrowserName=null;
	try{
	//sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
	
		/*/usr/bin/chromedriver
		 * */

		System.setProperty("webdriver.chrome.driver",Utils.configProp().getProperty("chromeDriver").toString());
		chromeOptions = new ChromeOptions();
		
		/*options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		options.addArguments("--print-to-pdf");
		options.addArguments("--start-maximized");*/
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		Log.info("New driver instantiated");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Log.info("Implicit wait applied on the driver for 10 seconds");
	    String uatlink = Utils.configProp().getProperty("uatlink").toString();
	 //  if(ParamEnv.contains("uat"))
	   //System.out.println(uatlink);
	    driver.get(uatlink);
	    Log.info("Web application launched successfully");
	    driver.manage().window().maximize();
		
	}catch (Exception e){
		Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
	}
	return driver;
}

public static String getTestCaseName(String sTestCase)throws Exception{
	String value = sTestCase;
	try{
		int posi = value.indexOf("@");
		value = value.substring(0, posi);
		posi = value.lastIndexOf(".");	
		value = value.substring(posi + 1);
		return value;
			}catch (Exception e){
		Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
		throw (e);
				}
		}

		 public static Properties configProp() throws Exception {
			 try {
				 
			//	File f = new File("src");
				 ///src/main/resources/config.uat.properties
		 		//prop.load(new FileReader("C://Users//carlos.almeida//Documents//GitHub//Testautomation//TestData//config.properties"));
				 prop.load(new FileReader(".//src//main//resources//config.uat.properties"));
				
		 	} catch (IOException e) {
		 		
		 		throw new Exception();
		 	}
			return prop;
			 
		 }

		 public static String takeScreenshot(WebDriver driver) throws Exception{
				try{
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					 pathToScreenshot = Utils.configProp().getProperty("Path_ScreenShot").toString() +System.currentTimeMillis() +"-Evidence.jpg";
					FileUtils.copyFile(scrFile, new File(pathToScreenshot));
					
				} catch (Exception e){
					Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
					throw new Exception();
				}
				return pathToScreenshot;
			}
}
