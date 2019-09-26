package com.alphasense.Testautomation.tests;

import org.apache.log4j.extras.DOMConfigurator;
import org.openqa.selenium.WebDriver;
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
import com.alphasense.Testautomation.utility.Utils;

public class Test_PageMyAccountOrderShipClothes {
	public WebDriver driver = null;
	public static String sTestCaseName;
	public static int iTestCaseRow;
	public PageMyAccount pagemyaccount = new PageMyAccount(driver);
	public PageLogin pagelogin = new PageLogin(driver);

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
			ExcelUtils.setExcelFile(path, "sheetOrderShipClothes");
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Log.startTestCase(sTestCaseName);
			
		  driver = Utils.OpenBrowser(iTestCaseRow);
		
			new BaseClass(driver);  
	        }
	  
	  @Test
	  public void TestMethod() throws Exception {
		  try{
			  boolean ShippResult = false;
		boolean loginResult	=  pagelogin.LoginIntoMyStore(Utils.configProp().getProperty("user").toString(),Utils.configProp().getProperty("passwd").toString());
			  
		if(loginResult == true) {
			 ShippResult=pagemyaccount.shippingClothes();
		}
					  
			//Assert.assertEquals(false, result);  
			if(ShippResult == true) {
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
	  public void afterMethod() {
		   Log.endTestCase(sTestCaseName);
		   driver.close();
	  		}
}
