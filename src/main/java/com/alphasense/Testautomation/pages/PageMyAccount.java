package com.alphasense.Testautomation.pages;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.alphasense.Testautomation.utility.Functions;
import com.alphasense.Testautomation.utility.Log;
import com.alphasense.Testautomation.utility.PDFGenerator;
import com.alphasense.Testautomation.utility.Utils;


public class PageMyAccount extends BaseClass{
	private static WebElement element = null;
	WebDriver driver;
	PDFGenerator pdfgenerator = new PDFGenerator();
	public String pathToScreenshot;
	
	public static boolean result; 
	
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
	public static WebElement link_BackToOrders() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath(".//a[contains(@title, 'Back to orders')]"));
            Log.info("The Element" +element.getTagName().toString()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement text_TotalPriceOrderSummaryPage() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath(".//*[@id= 'total_price']"));
            Log.info("The Element" +element.getText().toString()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
	
	
		
			public static WebElement link_PDFInvoiceDownload() throws Exception{
    	try{
    		
    		element = BaseClass.driver.findElement(By.xpath("(.//a[contains(@title, 'Invoice')])[1]"));
            Log.info("The Element" +element.getTagName().toString()+ "  is found on the Page teted");
            
    	}catch (Exception e){
       		Log.error("The Element" +element.getText()+ "  was not found on the Page");
       		throw(e);
       		}
       	return element;
        }
			
	public boolean searchClothes(String word) throws Exception {
		result = false;
		File file;
		PageMyAccount.input_search().sendKeys(word);
		pathToScreenshot=Utils.takeScreenshot(driver);
	     pdfgenerator.PDFcontent("Entered the keyword 'Dress' to search ", pathToScreenshot);
	     Files.deleteIfExists(Paths.get(pathToScreenshot));
		
		PageMyAccount.button_search().click();
		Utils.takeScreenshot(driver);
		
		int countTotalDresses=PageMyAccount.elements_Dresses(word);
		Integer intInstance = new Integer(countTotalDresses);      
		String numberAsString = intInstance.toString();
		
		if(PageMyAccount.h1Label_searchResultCountText().getText().contains(numberAsString)) {
			result=true;
			//BaseClass.pathToScreenshot = numberAsString;
		}
	
		return result;
		
	}

	public boolean shippingClothes() throws Exception {
		result = false;
		String word = Utils.configProp().getProperty("keyWordSearch").toString();
		searchClothes(word);
		
		pathToScreenshot=Utils.takeScreenshot(driver);
	     pdfgenerator.PDFcontent("View the search result for 'Dress' keyword - and clicking in Add to Chart button", pathToScreenshot);
	     
		Thread.sleep(2000L);
		
		ClickONbutton_addToChart();
		
		Thread.sleep(2000L);
		pathToScreenshot=Utils.takeScreenshot(driver);
	    pdfgenerator.PDFcontent("Click in Proceed to checkout ", pathToScreenshot);
		
		PageMyAccount.switchButton_proceedToCheckout().click();;
		
		Thread.sleep(2000L);
		
		BaseClass.auxValue=text_TotalPriceOrderSummaryPage().getText();
		PageMyAccount.ScrollDownClickOnButton_summaryProceedToCheckout();
		
		pathToScreenshot=Utils.takeScreenshot(driver);
	    pdfgenerator.PDFcontent("Summary screen - Click in Proceed to checkout", pathToScreenshot);

		Thread.sleep(2000L);
		PageMyAccount.button_addressProceedToCheckout();
	
		
		pathToScreenshot=Utils.takeScreenshot(driver);
	    pdfgenerator.PDFcontent("Click in Check box agree with terms", pathToScreenshot);
		Thread.sleep(2000L);
		PageMyAccount.inputType_checkBoxAgreeWithTerms().click();

		pathToScreenshot=Utils.takeScreenshot(driver);
	    pdfgenerator.PDFcontent("Click in proceed to checkout", pathToScreenshot);
		Thread.sleep(2000L);
		PageMyAccount.button_shippingProceedToCheckout();
	
		
		pathToScreenshot=Utils.takeScreenshot(driver);
	    pdfgenerator.PDFcontent("Click in button_payByBanwire", pathToScreenshot);
		Thread.sleep(2000L);
		PageMyAccount.button_payByBanwire().click();

		
		pathToScreenshot=Utils.takeScreenshot(driver);
	    pdfgenerator.PDFcontent("Click in IConfirmMyOrder", pathToScreenshot);
		Thread.sleep(2000L);
		PageMyAccount.button_IConfirmMyOrder().click();

		
		Thread.sleep(2000L);
		Thread.sleep(2000L);
		if(PageMyAccount.label_shippingConfirmation().getText().toString().contains("ORDER CONFIRMATION")) {
			result=true;
			pathToScreenshot=Utils.takeScreenshot(driver);
		     pdfgenerator.PDFcontent("Validate the Shipping confirmation page", pathToScreenshot);
		     BaseClass.pathToScreenshot = pathToScreenshot;
		}
		
		Thread.sleep(2000L);
		//PageMyAccount.button_linkUserAccount().click();
		
		return result;
		
	}

	public boolean downloadPDFInvoice() throws Exception {
		link_BackToOrders().click();
		//String totalPRice = BaseClass.auxValue;
		
		String pathDownloadDir = Utils.configProp().getProperty("pathDownload").toString();
		
		link_PDFInvoiceDownload().click();
		
		File pdfFile = Functions.getLatestFileFromDownload(pathDownloadDir);
		
		if (pdfFile.getName().contains("IN")) {
			result = true;
			
		System.out.println("THe file can found on this directory: "+pdfFile.getAbsolutePath().toString());
			
		}else {
			result = false;
		}
		
		return result;
	}

	

	
}
