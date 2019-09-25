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
import com.alphasense.Testautomation.utility.Utils;

public class Test_PageCreateAnAccount{

	public static WebDriver driver = null;
	public static String sTestCaseName;
	public static int iTestCaseRow;
	PageCreateAnAccount createaccountPage = new PageCreateAnAccount(driver);
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  
		  DOMConfigurator.configure("log4j.xml");
		  	sTestCaseName = this.toString();
			sTestCaseName = Utils.getTestCaseName(this.toString());
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "sheetCreateAccount");
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_setTestCaseName);
			Log.startTestCase(sTestCaseName);
			
		  driver = Utils.OpenBrowser(iTestCaseRow);
		  
		
			new BaseClass(driver);  
	        }
	  
	  @Test
	  public void TestMethod() throws Exception {
		  try{
			boolean result=false;
			result=createaccountPage.createAccount(iTestCaseRow);
			  
			//Assert.assertEquals(false, result);
			if(result == true) {
				  ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_ResultResponse);  
			  }

		  }catch (Exception e){
			 //ExcelUtils.setCellData("Fail", Hooks.iTestCaseRow, Constant.Col_Result);
			 //Utils.takeScreenshot(driver, Hooks.sTestCaseName);
			  Log.error(e.getMessage());
			  throw (e);
		  }
			
	  }
	  @AfterMethod
	  public void TearDown() {
		   Log.endTestCase(sTestCaseName);
		   if(driver != null) {
			   //driver.close();
		   }
		
	  		}
}
