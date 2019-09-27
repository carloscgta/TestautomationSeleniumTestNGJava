package com.alphasense.Testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.alphasense.Testautomation.utility.Constant;
import com.alphasense.Testautomation.utility.ExcelUtils;
import com.alphasense.Testautomation.utility.Functions;
import com.alphasense.Testautomation.utility.Log;
import com.alphasense.Testautomation.utility.PDFGenerator;
import com.alphasense.Testautomation.utility.Utils;

public class PageCreateAnAccount extends BaseClass {

	private static WebElement element = null;
	public static PDFGenerator pdfgenerator = new PDFGenerator();
	public String pathToScreenshot;
	public static boolean result;
	public PageCreateAnAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	public static WebElement button_LoginIn() throws Exception{
    	try{
           
    		element = BaseClass.driver.findElement(By.xpath("//*[contains(@class, 'header_user_info')]"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("btn_SignIn").toString()));
            
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
    	}catch (Exception e){
       		//Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_emailCreate() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='email_create']"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("btn_SignIn").toString()));
            
            Log.info("The Element" +element.getText()+ "  is found on the Page");
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	
	public static WebElement button_createAccount() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getoperty("btn_SignIn").toString()));
            
            Log.info("The Element" +element.getText()+ "  is found on the Page");
    	}catch (Exception e){
       		//Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement button_Register() throws Exception{
    	try{
           
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='submitAccount']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement radio_gender() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='uniform-id_gender1']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_firstName() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='customer_firstname']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		//Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_Lastname() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='customer_lastname']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_Password() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='passwd']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	public static void selectBox_DayByIndex(int index) throws Exception{
    	try{
    		
    		//WebElement element = (WebElement) Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
    		
    		
    		Select selectDay = new Select(BaseClass.driver.findElement(By.xpath("//*[@id='days']")));
    	
    			selectDay.selectByIndex(index);
   		
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
      
        }
	
	
	
	public static void selectBox_MonthByIndex(int index) throws Exception{
    	try{
    		
    		//WebElement element = (WebElement) Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
    		
    		
    		Select selectDay = new Select(BaseClass.driver.findElement(By.xpath("//*[@id='months']")));
    	
    			selectDay.selectByIndex(index);
    		
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
      
        }
	
	public static void selectBox_Year(int index) throws Exception{
    	try{
    		
    		   		
    		
    		Select selectDay = new Select(BaseClass.driver.findElement(By.xpath("//*[@id='years']")));
    	
    			selectDay.selectByIndex(index);
    		
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
      
        }
	
	public static WebElement checkBox_assignNewsLetter() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='newsletter']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	
	public static WebElement checkBox_receiveSpecialOffers() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='optin']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_AddressForm_FirstName() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='firstname']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	public static WebElement input_AddressForm_LastName() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='lastname']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_AddressForm_CompanyName() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='company']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_AddressForm_Address01() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='address1']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_AddressForm_Address2() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='address2']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	public static WebElement input_AddressForm_City() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='city']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	public static void select_AddressForm_state(String value) throws Exception{
    	try{
    		
    	    		
    		Select selectState = new Select(BaseClass.driver.findElement(By.xpath("//*[@id='id_state']")));
        	
    		selectState.selectByValue(value);
			
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
 
        }
		
	public static WebElement input_AddressForm_PostCode() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='postcode']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
		
	
	public static void select_AddressForm_Country(int index) throws Exception{
    	try{
    		
    		Select selectCountry = new Select(BaseClass.driver.findElement(By.xpath("//*[@id='id_country']")));
        	
    		selectCountry.selectByIndex(index);
			
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
 
        }
	
	public static WebElement input_AddressForm_AdditionaInfor() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='other']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_Homephone() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='phone']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_Mobilephone() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='phone_mobile']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_AliasAddress() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='alias']"));
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	 public boolean createAccount(int iTestCaseRow) throws Exception{
	     
		
	     
		 if(button_LoginIn().isDisplayed()) {
			 pathToScreenshot=Utils.takeScreenshot(driver);
		     pdfgenerator.PDFcontent("Click on Sigin Link", pathToScreenshot);
			 PageCreateAnAccount.button_LoginIn().click();
		 }
		 if(input_emailCreate().isDisplayed()) {
			 PageCreateAnAccount.input_emailCreate().sendKeys(Functions.randomAlphaEmail());
			 
		 }
	
		 
		 if( button_createAccount().isDisplayed()) {
			 pathToScreenshot=Utils.takeScreenshot(driver);
		     pdfgenerator.PDFcontent("Filling the account required information", pathToScreenshot);
			 PageCreateAnAccount.button_createAccount().click();
		 }
		  
		 if( radio_gender().isDisplayed()) {
			 PageCreateAnAccount.radio_gender().click();
		 }
		 
		 if( input_firstName().isDisplayed()) {
			 PageCreateAnAccount.input_firstName().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Name).toString());
		 }
		 
		 if( input_Lastname().isDisplayed()) {
			 PageCreateAnAccount.input_Lastname().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_LastName).toString());
			 pathToScreenshot=Utils.takeScreenshot(driver);
		     pdfgenerator.PDFcontent("Filling the account required information", pathToScreenshot);
		 }
		 
		 
		 if( input_Password().isDisplayed()) {
			 PageCreateAnAccount.input_Password().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_SetPassword).toString());
		 }
		 
		PageCreateAnAccount.checkBox_assignNewsLetter().click();
		 
		PageCreateAnAccount.selectBox_DayByIndex(10);
		PageCreateAnAccount.selectBox_MonthByIndex(7);
		PageCreateAnAccount.selectBox_Year(34);
		
		pathToScreenshot=Utils.takeScreenshot(driver);
	     pdfgenerator.PDFcontent("Filling the account required information", pathToScreenshot);
		PageCreateAnAccount.input_AddressForm_FirstName().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_AddressFirstName).toString());
		PageCreateAnAccount.input_AddressForm_LastName().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_AddressLastName).toString());
		PageCreateAnAccount.input_AddressForm_CompanyName().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Expected).toString());    
		
		PageCreateAnAccount.input_AddressForm_Address01().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_AddressLine2).toString());
		pathToScreenshot=Utils.takeScreenshot(driver);
	     pdfgenerator.PDFcontent("Filling the account required information", pathToScreenshot);
		
		PageCreateAnAccount.input_AddressForm_City().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_City).toString());
		select_AddressForm_state("2");
		
		PageCreateAnAccount.input_AddressForm_PostCode().sendKeys("46465");
		
		select_AddressForm_Country(1);
		
		PageCreateAnAccount.input_AddressForm_AdditionaInfor().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_AditionalInfo).toString());
		pathToScreenshot=Utils.takeScreenshot(driver);
	    pdfgenerator.PDFcontent("Filling the account required information", pathToScreenshot);
	     
	    
		PageCreateAnAccount.input_Mobilephone().sendKeys("123456789");
		
		PageCreateAnAccount.input_AliasAddress().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_AddressAlias).toString());
		pathToScreenshot=Utils.takeScreenshot(driver);
	     pdfgenerator.PDFcontent("Filling the account required information", pathToScreenshot);
	     
		PageCreateAnAccount.button_Register().click();
	         
	        if(PageLogin.button_OrderHistoryDetails().isDisplayed()){
	        	 result = true;
	        	 pathToScreenshot=Utils.takeScreenshot(driver);
	    	     pdfgenerator.PDFcontent("Click on button_createAccount", pathToScreenshot);
	         }else {
	        	 result = false;
	         }
	         
	         //Utils.driver.wait(15);
	         return result;
	        
	     }
	

}
