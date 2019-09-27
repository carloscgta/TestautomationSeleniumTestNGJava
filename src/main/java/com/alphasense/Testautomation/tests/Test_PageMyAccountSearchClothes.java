package com.alphasense.Testautomation.tests;

import org.apache.log4j.extras.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alphasense.Testautomation.pages.BaseClass;
import com.alphasense.Testautomation.pages.PageLogin;
import com.alphasense.Testautomation.pages.PageMyAccount;
import com.alphasense.Testautomation.utility.Constant;
import com.alphasense.Testautomation.utility.ExcelUtils;
import com.alphasense.Testautomation.utility.Log;
import com.alphasense.Testautomation.utility.PDFGenerator;
import com.alphasense.Testautomation.utility.Utils;
import com.beust.jcommander.Parameter;

public class Test_PageMyAccountSearchClothes {
	
	public WebDriver driver = null;
	public static String sTestCaseName;
	public static int iTestCaseRow;
	public PageMyAccount pagemyaccount = new  PageMyAccount(driver) ;
	PDFGenerator pdfgenerator = new PDFGenerator();
	public PageLogin pagelogin = new PageLogin(driver);
	public boolean loginResult = false;
	public boolean result = false;
	  @BeforeMethod
	  @Parameters
	  public void beforeMethod() throws Exception {
		 
		  System.out.println( Utils.configProp().getProperty("uatlink").toString());
		  System.out.println( Utils.configProp().getProperty("user").toString());
		  System.out.println(  Utils.configProp().getProperty("passwd").toString());
		  System.out.println( "This test search Dresses and assert can result count"+Utils.configProp().getProperty("keyWordSearch").toString());
		  System.out.println( "The test report can be found in:"+Utils.configProp().getProperty("Path_ScreenShot").toString());
		  
		  DOMConfigurator.configure("log4j.xml");
		  	sTestCaseName = this.toString();
			sTestCaseName = Utils.getTestCaseName(this.toString());
			String path= Utils.configProp().getProperty("Path_TestData").toString();
			ExcelUtils.setExcelFile(path, "Test_PageMyAccountSearchClothes");
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Log.startTestCase(sTestCaseName);
			
		  driver = Utils.OpenBrowser(iTestCaseRow);
		  pdfgenerator.startPDF(sTestCaseName);
		
			new BaseClass(driver);  
	        }
	  
	  @Test(enabled=true)
	  public void TestMethod() throws Exception {
		  try{
			loginResult = pagelogin.LoginIntoMyStore(Utils.configProp().getProperty("user").toString(),Utils.configProp().getProperty("passwd").toString());
			
			
			result=pagemyaccount.searchClothes(Utils.configProp().getProperty("keyWordSearch").toString());
			  
			 Assert.assertTrue(result, "Search was performed successfully");
			 
			if(loginResult =true  && result == true) {
				  ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_SetResultOrderClothes);  
				 
			  }

		  }catch (Exception e){
			 ExcelUtils.setCellData("Failed", iTestCaseRow, Constant.Col_SetResultOrderClothes);
			 Utils.takeScreenshot(driver);
			  Log.error(e.getMessage());
			  throw (e);
		  }
			
	  }
	  @AfterMethod
	  public void afterMethod() throws Exception {
		   Log.endTestCase(sTestCaseName);
		   pdfgenerator.closePDF(result);
		   driver.quit();
	  		}
	
}
