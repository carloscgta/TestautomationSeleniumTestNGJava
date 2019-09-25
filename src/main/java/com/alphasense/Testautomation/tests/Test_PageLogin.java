package com.alphasense.Testautomation.tests;
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
		  
		 
		  DOMConfigurator.configure("log4j.xml");
		  	sTestCaseName = this.toString();
			sTestCaseName = Utils.getTestCaseName(this.toString());
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Test_PageLogin");
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
			//pdfgenerator.geraPDF(sTestCaseName, result);
			
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
	

