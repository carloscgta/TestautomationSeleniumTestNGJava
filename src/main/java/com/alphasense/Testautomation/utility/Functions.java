package com.alphasense.Testautomation.utility;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.alphasense.Testautomation.pages.BaseClass;

public class Functions  {

	
	
	public static String  nameSheet = null;
	  //Method to generate a random E-mail
    public static String randomAlphaEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String mail = "Regression_seleniumTest@alpha-sense.com";
        String s = "";
        Random random = new Random();
        int randomLen = 3 + random.nextInt(9);
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            s += c;

        }
        return s.concat(mail).toString();
    }

    public static void scrollToElement(By locator) throws InterruptedException{
        WebElement element = BaseClass.driver.findElement(locator);
      //  WebElement element = driver.findElement(By.id("id_of_element"));
        Thread.sleep(500);
        Thread.sleep(500);
        ((JavascriptExecutor) BaseClass.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        WebElement elementToHover = BaseClass.driver.findElement(locator);
        Thread.sleep(500);
        Actions builder = new Actions(BaseClass.driver);
        Thread.sleep(500);
        builder.moveToElement(elementToHover).build().perform();
        //Actions actions = new Actions(BaseClass.driver);
        //actions.moveToElement(element);

    }
    
    /* Get the latest file from from Download Folder*/
	public static File getLatestFileFromDownload(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	
	/* Verify if the  file exist in a specific directory using the extension */
	public static boolean check_FileDownloaded(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	//Not used
	public static boolean verifyDownloadedFile(String stringLocationFolder) throws InterruptedException {
        File directory = new File(stringLocationFolder);
        boolean result=  false;
        File[] filesList =null;
    
                filesList =  directory.listFiles();
                for (File file : filesList) {
                	
                	if(file.getName().contains("IN127609.pdf")) {
                                    
                    	result = true;
                    }
                }
				return result;
                
                
                
            }
    
	
}
