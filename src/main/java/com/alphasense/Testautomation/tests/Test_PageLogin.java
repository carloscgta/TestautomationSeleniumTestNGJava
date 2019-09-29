package com.alphasense.Testautomation.tests;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.extras.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alphasense.Testautomation.pages.BaseClass;
import com.alphasense.Testautomation.pages.PageLogin;
import 
com.alphasense.Testautomation.utility.Constant;
import com.alphasense.Testautomation.utility.ExcelUtils;
import com.alphasense.Testautomation.utility.Log;
import com.alphasense.Testautomation.utility.PDFGenerator;
import com.alphasense.Testautomation.utility.Utils;
import com.itextpdf.text.DocumentException;


public class Test_PageLogin {

	public WebDriver driver = null;
	public static String sTestCaseName;
	public static int iTestCaseRow;
	public static boolean result;
	PageLogin pagelogin = new PageLogin(driver);
	
	PDFGenerator pdfgenerator = new PDFGenerator();

	  @BeforeMethod
	  @Parameters
	  public void beforeMethod() throws Exception {
		  
		/*String ParamEnv = System.getProperty("uat").toString();
		  String uatlink = Utils.configProp().getProperty("uatlink").toString();
		if(ParamEnv.contains("uat")) {
			  System.out.println(uatlink);
		  }*/
		  
		  System.out.println( Utils.configProp().getProperty("uatlink").toString());
		  System.out.println( Utils.configProp().getProperty("user").toString());
		  System.out.println(  Utils.configProp().getProperty("passwd").toString());
		  System.out.println( "This test search Dresses and assert can result count"+Utils.configProp().getProperty("keyWordSearch").toString());
		  System.out.println( "The test report can be found in:"+Utils.configProp().getProperty("Path_ScreenShot").toString());
				 
		  DOMConfigurator.configure("log4j.xml");
		  	sTestCaseName = this.toString();
			sTestCaseName = Utils.getTestCaseName(this.toString());
			String pathtoData= Utils.configProp().getProperty("Path_TestData").toString();
			ExcelUtils.setExcelFile(pathtoData, "Test_PageLogin");
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Log.startTestCase(sTestCaseName);
			
			 pdfgenerator.startPDF(sTestCaseName);
			
		  driver = Utils.OpenBrowser(iTestCaseRow);
		
			new BaseClass(driver);  
	        }
	  
	  @Test
	  public void TestMethod() throws Exception {
		  try{
			 result=pagelogin.DoLogin(iTestCaseRow);;
			 
			
			 Assert.assertTrue(result, "Login should be successful, but actually wasn't.");
			if(result == true) {
				  ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_Result);  
			  }
		
			
		  }catch (Exception e){
			 ExcelUtils.setCellData("Failed", iTestCaseRow, Constant.Col_Result);
			
			  Log.error("Failed", e);
			  throw (e);
		  }
	  }
	  @AfterMethod
	  public void afterMethod() throws Exception {
		   Log.endTestCase(sTestCaseName);
		   pdfgenerator.closePDF(result);
		   driver.close();
	  		}
}
	

