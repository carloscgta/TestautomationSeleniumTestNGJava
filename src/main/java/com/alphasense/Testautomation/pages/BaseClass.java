package com.alphasense.Testautomation.pages;

import org.openqa.selenium.WebDriver;

public class BaseClass {

	public static WebDriver driver;
	public static boolean bResult;
	public static String pathToScreenshot = null;
	public static String auxValue;
	public BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}
}
