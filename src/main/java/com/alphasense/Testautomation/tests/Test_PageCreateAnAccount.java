package com.alphasense.Testautomation.tests;

import org.apache.log4j.extras.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alphasense.Testautomation.pages.BaseClass;
import com.alphasense.Testautomation.pages.PageCreateAnAccount;
import com.alphasense.Testautomation.utility.Constant;
import com.alphasense.Testautomation.utility.ExcelUtils;
import com.alphasense.Testautomation.utility.Log;
import com.alphasense.Testautomation.utility.PDFGenerator;
import com.alphasense.Testautomation.utility.Utils;

public class Test_PageCreateAnAccount{
	

	public static WebDriver driver = null;
	public static String sTestCaseName;
	public static int iTestCaseRow;
	PageCreateAnAccount createaccountPage = new PageCreateAnAccount(driver);
	PDFGenerator pdfgenerator = new PDFGenerator();
	public static boolean result;
	
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  
		  System.out.println( Utils.configProp().getProperty("uatlink").toString());
		  System.out.println( Utils.configProp().getProperty("user").toString());
		  System.out.println(  Utils.configProp().getProperty("passwd").toString());
		  System.out.println( "This test search Dresses and assert can result count"+Utils.configProp().getProperty("keyWordSearch").toString());
		  System.out.println( "The test report can be found in:"+Utils.configProp().getProperty("Path_ScreenShot").toString());
		  
		  	DOMConfigurator.configure("log4j.xml");
		  	
			sTestCaseName = Utils.getTestCaseName(this.toString());
			String pathtoData= Utils.configProp().getProperty("Path_TestData").toString();
			ExcelUtils.setExcelFile(pathtoData, "sheetCreateAccount");
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_setTestCaseName);
			Log.startTestCase(sTestCaseName);
			
		  driver = Utils.OpenBrowser(iTestCaseRow);
		  
		  //Create the PDF file with the test class name
		  pdfgenerator.startPDF(sTestCaseName);
		
			new BaseClass(driver);  
	        }
	  
	  @Test
	  public void TestMethod() throws Exception {
		  try{
			result=false;
			result=createaccountPage.createAccount(iTestCaseRow);
			  
			 Assert.assertTrue(result, "Account was created, you can check the evidences in the pdf report.");
			 
			if(result == true) {
				  ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_ResultResponse);  
			  }

		  }catch (Exception e){
			  ExcelUtils.setCellData("Failed", iTestCaseRow, Constant.Col_ResultResponse);  
			  Log.error("Failed",e);
			  throw (e);
		  }
			
	  }
	  @AfterMethod
	  public void TearDown() throws Exception {
		   Log.endTestCase(sTestCaseName);
		   pdfgenerator.closePDF(result);
		   if(driver != null) {
			driver.close();
		   }
		
	  		}
}
