package com.alphasense.Testautomation.tests;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.extras.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alphasense.Testautomation.pages.BaseClass;
import com.alphasense.Testautomation.pages.PageLogin;
import com.alphasense.Testautomation.utility.Constant;
import com.alphasense.Testautomation.utility.ExcelUtils;
import com.alphasense.Testautomation.utility.Log;
import com.alphasense.Testautomation.utility.PDFGenerator;
import com.alphasense.Testautomation.utility.Utils;
import com.itextpdf.text.DocumentException;

@Test ()
public class Test_PageLogin {

	public WebDriver driver = null;
	public static String sTestCaseName;
	public static int iTestCaseRow;
	public static boolean result;
	
	PDFGenerator pdfgenerator = new PDFGenerator();

	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  
		 // String ParamEnv = System.getProperty("uat").toString();
		  String uatlink = Utils.configProp().getProperty("uatlink").toString();
		  System.out.println(uatlink);
				 
		  DOMConfigurator.configure("log4j.xml");
		  	sTestCaseName = this.toString();
			sTestCaseName = Utils.getTestCaseName(this.toString());
			String pathtoData= Utils.configProp().getProperty("Path_TestData").toString();
			ExcelUtils.setExcelFile(pathtoData, "Test_PageLogin");
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Log.startTestCase(sTestCaseName);
			
			 pdfgenerator.iniciaPDF(sTestCaseName);
			
		  driver = Utils.OpenBrowser(iTestCaseRow);
		
			new BaseClass(driver);  
	        }
	  
	  @Test
	  public void TestMethod() throws Exception {
		  try{
			 result=PageLogin.DoLogin(iTestCaseRow);;
			 
			//Assert.assertEquals(true, result);  
			if(result == true) {
				  ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_Result);  
			  }
		
			
		  }catch (Exception e){
			 ExcelUtils.setCellData("Failed", iTestCaseRow, Constant.Col_Result);
			 //Utils.takeScreenshot(driver, Hooks.sTestCaseName);
			  Log.error(e.getMessage());
			  throw (e);
		  }
			
	  }
	  @AfterMethod
	  public void afterMethod() throws Exception {
		   Log.endTestCase(sTestCaseName);
		   pdfgenerator.fechaPDF(result);
		   driver.close();
	  		}
}
	

