package com.alphasense.Testautomation.utility;

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
}
