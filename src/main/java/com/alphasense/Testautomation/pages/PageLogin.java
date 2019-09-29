package com.alphasense.Testautomation.pages;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.alphasense.Testautomation.utility.Constant;
import com.alphasense.Testautomation.utility.ExcelUtils;
import com.alphasense.Testautomation.utility.Log;
import com.alphasense.Testautomation.utility.PDFGenerator;
import com.alphasense.Testautomation.utility.Utils;



public class PageLogin extends BaseClass {

	private static WebElement element = null;
	public static PDFGenerator pdfgenerator = new PDFGenerator();
	
	public PageLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public static WebElement link_SignIn() throws Exception{
    	try{
           
    		element = driver.findElement(By.xpath(".//a[contains(@title, 'Log in to your customer account')]"));
    		
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("link_Login").toString()));
            
            Log.info("The Element" + element.getText()+ "  is found on the Page");
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page",e);
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_email() throws Exception{
    	try{
           
    		element = driver.findElement(By.xpath("//*[@id=\"email\"]"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("input_email").toString()));
            
            Log.info("The Element" + element.getText()+ "  is found on the Page");
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page", e);
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement input_password() throws Exception{
    	try{
           
    		element = driver.findElement(By.xpath("//*[@id='passwd']"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("input_passwd").toString()));
            
            Log.info("The Element" +element.getText()+ "  is found on the Page");
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page", e);
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement button_SignIn() throws Exception{
    	try{
           
    		element = driver.findElement(By.xpath("//*[@id='SubmitLogin']"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("btn_SignIn").toString()));
            
            Log.info("The Element" +element.getText()+ "  is found on the Page");
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page",e);
       		throw(e);
       		}
       	return element;
        }
	
	
	
	public static WebElement input_createAccountEmailAddress() throws Exception{
    	try{
           
    		element = driver.findElement(By.xpath("//*[@id='email_create']"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("btn_SignIn").toString()));
            
            Log.info("The Element" +element.getText()+ "  was found on the Page");
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page",e);
       		throw(e);
       		}
       	return element;
        }
	

	public static WebElement button_OrderHistoryDetails() throws Exception{
    	try{
           
    		element = driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a/span"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("btn_SignIn").toString()));
            
            Log.info("The Element" +element.getText()+ " was found on the Page");
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page", e);
       		throw(e);
       		}
       	return element;
        }
	
	
	public static WebElement h1classtext_AthenticationErrorMessage() throws Exception{
    	try{
          
    		element = driver.findElement(By.xpath("//*[contains(text(),'failed')]"));
            
    		//element = driver.findElement(By.xpath(Utils.configProperties("PageLogin").getProperty("btn_SignIn").toString()));
            
            Log.info("The Element" +element.getText()+ " was found on the Page");
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page",e);
       		Log.error("Falha", e);
       		throw(e);
       		}
       	return element;
        }
	 public static String pathToScreenshot;
	 public boolean DoLogin(int iTestCaseRow) throws Exception{
		  pathToScreenshot=Utils.takeScreenshot(driver);
		  pdfgenerator.PDFcontent("Home Page - Click in Sign to go to the Login Page", pathToScreenshot);
	     Files.deleteIfExists(Paths.get(pathToScreenshot));

	     	link_SignIn().click();
	    	 Thread.sleep(2000L);
		 	Thread.sleep(2000L);
		 	Thread.sleep(2000L);
		   	// Storing the UserName in to a String variable and Getting the UserName from Test Data Excel sheet
	     	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	     	// Constant.Col_UserName is the column number for UserName column in the Test Data sheet
	     
		 	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);

	     	// Here we are sending the UserName string to the UserName input_email
		 			 	
	        input_email().sendKeys(sUserName); 
	     
	         // Printing the logs for what we have just performed
	         Log.info(sUserName+" is entered in UserName text box" );
	         
	         String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
	       
	         input_password().sendKeys(sPassword);
	         
	         Log.info(sPassword+" is entered in Password text box" );
	         
	         pathToScreenshot=Utils.takeScreenshot(driver);
		     pdfgenerator.PDFcontent("Entered Username and Password and click in Sign In Button", pathToScreenshot);
		     Files.deleteIfExists(Paths.get(pathToScreenshot));
	         button_SignIn().click();
	         Thread.sleep(2000L);
	         Thread.sleep(2000L);
	         Thread.sleep(2000L);
	         
	         pathToScreenshot=Utils.takeScreenshot(driver);
		     pdfgenerator.PDFcontent("My Account", pathToScreenshot);
	         
	          if(button_OrderHistoryDetails().isDisplayed()){
	        	 bResult = true;
	        	 pathToScreenshot=Utils.takeScreenshot(driver);
			     pdfgenerator.PDFcontent("Screen My Account", pathToScreenshot);
			     Files.deleteIfExists(Paths.get(pathToScreenshot));
	        	ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_Result);
	         }else {
	        	 bResult = false;
	        	 ExcelUtils.setCellData("Failed", iTestCaseRow, Constant.Col_Result);
	        	 JavascriptExecutor jse = (JavascriptExecutor) driver;
		         jse.executeScript("arguments[0].style.border='3px solid red'", h1classtext_AthenticationErrorMessage());
	         }
	         
	         
	         Log.info("Click action is performed on Submit button");
			
	         return bResult;
	     }
 	 
	 public boolean LoginIntoMyStore(String user, String password) throws Exception{
	     	
		   Thread.sleep(2000L);
	         Thread.sleep(2000L);
	         Thread.sleep(2000L);
	         
		 	link_SignIn().click();
		    Thread.sleep(2000L);
	         Thread.sleep(2000L);
	         Thread.sleep(2000L);
	  
	         driver.navigate().refresh();
	         
	        input_email().sendKeys(user); 
	        input_password().sendKeys(password);
	        Utils.takeScreenshot(driver);
	      
	        pathToScreenshot=Utils.takeScreenshot(driver);
		     pdfgenerator.PDFcontent("Performing the Login", pathToScreenshot);
		     Files.deleteIfExists(Paths.get(pathToScreenshot));
	         
	        button_SignIn().click();
	        Utils.takeScreenshot(driver); 
	       
	        if(button_OrderHistoryDetails().isDisplayed()){
	        	 bResult = true;
	        	 pathToScreenshot=Utils.takeScreenshot(driver);
			     pdfgenerator.PDFcontent("Validation of the error message", pathToScreenshot);
			     Files.deleteIfExists(Paths.get(pathToScreenshot));
		         
	         }else {
	        	 bResult = false;
	        	
	         }

			
	         return bResult;
	     }
	
	 public boolean InvalidLoginIntoMyStore(String user, String password) throws Exception{
	     	
	     	
		 	link_SignIn().click();
		 	
		 	
	        input_email().sendKeys(user); 
	        
	        input_password().sendKeys(password);
	        
	       
	        pathToScreenshot=Utils.takeScreenshot(driver);
		    pdfgenerator.PDFcontent("Performing the Login", pathToScreenshot);
		    Files.deleteIfExists(Paths.get(pathToScreenshot));
	         
	        button_SignIn().click();
	        Utils.takeScreenshot(driver); 
	       
	        
	        if(h1classtext_AthenticationErrorMessage().isDisplayed()){
	        	 bResult = false;
	        	 pathToScreenshot=Utils.takeScreenshot(driver);
			     pdfgenerator.PDFcontent("Validation of the error message", pathToScreenshot);
			     Files.deleteIfExists(Paths.get(pathToScreenshot));
			     JavascriptExecutor jse = (JavascriptExecutor) driver;
		         jse.executeScript("arguments[0].style.border='3px solid red'", h1classtext_AthenticationErrorMessage());
		         
	         }else {
	        	 bResult = true;
	        	
	         }

	         return bResult;
	     }
}
