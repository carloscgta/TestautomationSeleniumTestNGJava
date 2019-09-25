package com.alphasense.Testautomation.pages;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;

import com.alphasense.Testautomation.utility.Constant;
import com.alphasense.Testautomation.utility.ExcelUtils;
import com.alphasense.Testautomation.utility.Functions;
import com.alphasense.Testautomation.utility.Log;
import com.alphasense.Testautomation.utility.Utils;


public class PageMyAccount extends BaseClass{
	private static WebElement element = null;

	public PageMyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement input_search() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//input[@id='search_query_top']"));
    	
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement button_search() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='searchbox']/button"));
    	
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement h1Label_searchResultCountText() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("//*[@id='center_column']/h1/span[2]"));
    	
            Log.info("The Element" +element.getText()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }

	
	public static void ClickONbutton_addToChart() throws Exception{
    	try{
    		
    		Functions.scrollToElement(By.xpath("(.//div[@class='product-container'])[1]"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		Thread.sleep(2000L);
    		Thread.sleep(2000L);
    		element = BaseClass.driver.findElement(By.xpath(".//*[text()='Add to cart']"));
    		
    		element.click();
    		
    		Thread.sleep(2000L);
    		
    		
            Log.info("The Element" +element.getTagName()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getTagName()+ "  was not found on the Page");
       		throw(e);
       		}
       	
        }
	
	public static void ClickONbutton_ProceedToChart(By Element) throws Exception{
    	try{
    		
    		Functions.scrollToElement(By.xpath("(.//div[@class='product-container'])[1]"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		Thread.sleep(2000L);
    		Thread.sleep(2000L);
    		element = BaseClass.driver.findElement(By.xpath(".//*[text()='Add to cart']"));
    		
    		element.click();
    		
    		Thread.sleep(2000L);
    		
    		
            Log.info("The Element" +element.getTagName()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getTagName()+ "  was not found on the Page");
       		throw(e);
       		}
       	
        }

	public static WebElement switchButton_proceedToCheckout() throws Exception{
    	try{
    		Thread.sleep(2000L);
    		//BaseClass.driver.switchTo().alert();	
    		//WebElement buttonProceedToCheckout = BaseClass.driver.findElement(By.xpath(".//a[contains(@title,'Proceed to checkout')]"));
    		element = BaseClass.driver.findElement(By.xpath(".//a[contains(@title,'Proceed to checkout')]"));
    		//BaseClass.driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")));
    		Thread.sleep(2000L);
    	
    		//element.click();
    		// Switching to Alert        
    			
  
    	    // Capturing alert message.    
    	    // String alertMessage= driver.switchTo().alert().getText();
              Log.info("The Element" +element.getTagName().toString()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	public static void ScrollDownClickOnButton_summaryProceedToCheckout() throws Exception{
    	try{
    		
    		/*Functions.scrollToElement(By.xpath("//*[@id=\"center_column\"]/div[3]/div[1]/ul"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		Thread.sleep(2000L);*/
    		Thread.sleep(2000L);
    		Functions.scrollToElement(By.xpath(".//*[text()='Proceed to checkout']"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		WebElement elementSummary = BaseClass.driver.findElement(By.xpath(".//*[text()='Proceed to checkout']"));
    		Thread.sleep(2000L);
    		elementSummary.click();
    		Thread.sleep(2000L);
    		Thread.sleep(2000L);
          //  Log.info("The Element" +elementSummary.getTagName().toString()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		
       		throw(e);
       		}
       	//return element;
        }
	
	
	
	public static void button_addressProceedToCheckout() throws Exception{
    	try{
    		Thread.sleep(2000L);
    		Functions.scrollToElement(By.xpath(".//*[text()='Proceed to checkout']"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		element = BaseClass.driver.findElement(By.xpath(".//*[text()='Proceed to checkout']"));
    		Thread.sleep(2000L);
    		
    		element.click();
    		Thread.sleep(2000L);
    		Thread.sleep(2000L);
            Log.info("The Element   is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element   was not found on the Page");
       		throw(e);
       		}
       	//return element;
        }
	
	
	public static WebElement inputType_checkBoxAgreeWithTerms() throws Exception{
    	try{
    		//*[@id='uniform-cgv']
    		Thread.sleep(2000L);
    		Functions.scrollToElement(By.xpath("//input[@id='cgv']"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		Thread.sleep(2000L);
    		
    		element = BaseClass.driver.findElement(By.xpath("//input[@id='cgv']"));
    	
            Log.info("The Element is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static void button_shippingProceedToCheckout() throws Exception{
    	try{
    		
    		Thread.sleep(2000L);
    		Functions.scrollToElement(By.xpath("//button[@name='processCarrier']"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		element = BaseClass.driver.findElement(By.xpath("//button[@name='processCarrier']"));
    		Thread.sleep(2000L);
    		
    		element.click();
    		Thread.sleep(2000L);
    	
            Log.info("The Element  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       //	return element;
        }
	
	
	
	
	
	public static WebElement button_payByBanwire() throws Exception{
    	try{
    		
    		Thread.sleep(2000L);
    		Functions.scrollToElement(By.xpath(".//a[contains(@title,'Pay by bank wire')]"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		Thread.sleep(2000L);
    		Thread.sleep(2000L);
    		element = BaseClass.driver.findElement(By.xpath(".//a[contains(@title,'Pay by bank wire')]"));
    	
            Log.info("The Element is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	
	//This Element should contain the text "Your order on My Store is complete."
	public static WebElement label_shippingConfirmation() throws Exception{
    	try{
    		
    		/*
    		 * .//strong[contains(text(),'Here is a short summary of your order')]
    		 * */
    		element = BaseClass.driver.findElement(By.xpath("//div[contains(@id,'center_column')]"));
    	
            Log.info("The Element  is found on the Page");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement button_IConfirmMyOrder() throws Exception{
    	try{
    		
    		Thread.sleep(2000L);
    
    		Functions.scrollToElement(By.xpath(".//span[contains(text(),'I confirm my order')]"));
    		BaseClass.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    		Thread.sleep(2000L);
    		
    		element = BaseClass.driver.findElement(By.xpath(".//span[contains(text(),'I confirm my order')]"));
    	
            Log.info("The Element  is found on the Page");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
	
	
	public static WebElement button_linkUserAccount() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath(".//a[contains(@title,'View my customer account')]"));
    	
            Log.info("The Element  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement button_orderHistoryAndDetails() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath(".//a[contains(@title,'Orders')]"));
    	
            Log.info("The Element  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element was not found on the Page");
       		throw(e);
       		}
       	return element;
        }

	public static WebElement icon_ReferenceopenOrderDetails() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("(.//span[contains(@class,'footable-toggle')])[1]"));
    	
            Log.info("The Element is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	

	public static WebElement download_invoicePDF() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("(.//a[contains(@title,'Invoice')])[1]"));
    	
            Log.info("The Element is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	

	
	public static int count =0;
	public static int elements_Dresses(String textClotheToSearch) throws Exception{
    	try{
    		
    	 WebElement ulElement;
    	 
    	 ulElement = BaseClass.driver.findElement(By.xpath("//*[@id='center_column']/ul"));
    		
    		 List<WebElement> listElements = ulElement.findElements(By.tagName("li"));

 		    for (WebElement li : listElements) {
 		        if(li.getText().contains(textClotheToSearch)) {
 		        	count = count +1;
 		        	System.out.println("The word Dress was found on this Search Result"+textClotheToSearch);
 		        }
 		    }
 		   System.out.println("Search Result Count Total:"+count);
            Log.info("The Element is found on the Page");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return count;
       
	}
		
	public boolean searchClothes(String word) throws Exception {
		boolean result = false;
		PageMyAccount.input_search().sendKeys(word);
		Utils.takeScreenshot(driver);
		
		PageMyAccount.button_search().click();
		Utils.takeScreenshot(driver);
		
		int countTotalDresses=PageMyAccount.elements_Dresses(word);
		Integer intInstance = new Integer(countTotalDresses);      
		String numberAsString = intInstance.toString();
		
		if(PageMyAccount.h1Label_searchResultCountText().getText().contains(numberAsString)) {
			result=true;
		}
	
		return result;
		
	}

	public boolean shippingClothes() throws Exception {
		boolean result = false;
		String word = Utils.configProp().getProperty("keyWordSearch").toString();
		searchClothes(word);
		//PageMyAccount.input_search().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_ClothingName).toString());
		Utils.takeScreenshot(driver);

		Utils.takeScreenshot(driver);
		Thread.sleep(2000L);
		

		ClickONbutton_addToChart();
		
		Thread.sleep(2000L);
		Utils.takeScreenshot(driver);
		
		PageMyAccount.switchButton_proceedToCheckout().click();;
		
		
		Utils.takeScreenshot(driver);
		Thread.sleep(2000L);
		
		PageMyAccount.ScrollDownClickOnButton_summaryProceedToCheckout();
		
		Utils.takeScreenshot(driver);
		Thread.sleep(2000L);
		PageMyAccount.button_addressProceedToCheckout();
		Utils.takeScreenshot(driver);
		
		Thread.sleep(2000L);
		PageMyAccount.inputType_checkBoxAgreeWithTerms().click();
		Utils.takeScreenshot(driver);
		
		
		Thread.sleep(2000L);
		PageMyAccount.button_shippingProceedToCheckout();
		Utils.takeScreenshot(driver);
		
		
		Thread.sleep(2000L);
		PageMyAccount.button_payByBanwire().click();
		Utils.takeScreenshot(driver);
		
		
		Thread.sleep(2000L);
		PageMyAccount.button_IConfirmMyOrder().click();
		Utils.takeScreenshot(driver);
		
		Thread.sleep(2000L);
		Thread.sleep(2000L);
		if(PageMyAccount.label_shippingConfirmation().getText().toString().contains("ORDER CONFIRMATION")) {
			result=true;
		}
		
		Thread.sleep(2000L);
		PageMyAccount.button_linkUserAccount().click();
		
		return result;
		
	}
	
	
	public static boolean verifyDownloadedFile(String stringLocationFolder) throws InterruptedException {
        File directory = new File(stringLocationFolder);

        boolean  result1=  false;
        File[] filesList =null;
    
                filesList =  directory.listFiles();
                for (File file : filesList) {
                	
                	if(file.getName().contains("IN127609.pdf")) {
                                    
                    	result1 = true;
                    }
                }
				return result1;
                
                
                
            }
    
	
}
