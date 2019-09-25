package com.alphasense.Testautomation.tests;

import java.io.IOException;

import org.apache.log4j.extras.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Test_PageInvalidLogin{


	public WebDriver driver = null;
	public static String sTestCaseName;
	public static int iTestCaseRow;
	PDFGenerator pdfgenerator = new PDFGenerator();
	public static boolean result;

	  @BeforeMethod
	  public void beforeMethod() throws Exception {
			
		  
			DOMConfigurator.configure("log4j.xml");
		  	sTestCaseName = this.toString();
			sTestCaseName = Utils.getTestCaseName(this.toString());
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Test_PageLogin");
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Log.startTestCase(sTestCaseName);
			
		  driver = Utils.OpenBrowser(iTestCaseRow);
		  pdfgenerator.iniciaPDF(sTestCaseName);
		
			new BaseClass(driver);  
	        }
	  
	  @Test
	  public void TestMethod() throws Exception {
		  try{
			  
			 result=PageLogin.InvalidLoginIntoMyStore(Utils.configProp().getProperty("user").toString(), Utils.configProp().getProperty("invalidPass").toString());
			  
		//	Assert.assertEquals(false, result);  
			if(result == false) {
				  ExcelUtils.setCellData("Passed",iTestCaseRow, Constant.Col_Result);  
			  }

		  }catch (Exception e){
			 //ExcelUtils.setCellData("Fail", Hooks.iTestCaseRow, Constant.Col_Result);
			 //Utils.takeScreenshot(driver, Hooks.sTestCaseName);
			  Log.error(e.getMessage());
			  throw (e);
		  }
			
	  }
	  @AfterMethod
	  public void afterMethod() throws DocumentException, IOException {
		   Log.endTestCase(sTestCaseName);
		   pdfgenerator.fechaPDF(result);
		   driver.close();
	  		}
}
