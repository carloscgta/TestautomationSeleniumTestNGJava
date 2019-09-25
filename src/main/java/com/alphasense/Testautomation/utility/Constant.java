package com.alphasense.Testautomation.utility;

public class Constant {
	//pre-prod
    //public static final String URL = "https://10.129.105.121:6501/ouaf/loginPage.jsp";
    
    
    //UAT
    public static final String URL = "http://automationpractice.com/index.php";
    
    /*/var/lib/jenkins/workspace/SELENIUM/psrmSeleniumAutomation/testData/
     * 
     * 
     * C:\\Users\\carlos.almeida\\Documents\\SIGT\\Automation\\NewVentures\\psrm\\testData\\
     * C:\projetos\Automation\SeleniumAutomationProject\testData\TestData.xlsx
     * 
     * */
	//public static final String URL = "https://10.129.106.198:6501/ouaf/loginPage.jsp"; /psrm/testData
	public static final String Path_TestData = "C:\\Users\\carlos.almeida\\Documents\\SIGT\\Automation\\NewVentures\\Testautomation\\TestData\\";
	public static final String File_TestData = "testData.xlsx";
		
	//Test Data Sheet Test_PageLogin
	public static final int Col_TestCaseName = 0;	
	public static final int Col_UserName =1;
	public static final int Col_Password = 2;
	public static final int Col_Browser = 3;
	public static final int Col_Result = 5;
	public static final int Col_Expected =4;
	
	//Test Data Sheet Test_PageCreateAnAccount
	public static final int Col_setTestCaseName = 0;	
	public static final int Col_Title =1;
	public static final int Col_Name = 2;
	public static final int Col_LastName = 3;
	public static final int Col_SetBrowser = 4;
	public static final int Col_SetEmail = 5;
	public static final int Col_SetPassword= 6;
	public static final int Col_AddressFirstName= 7;
	public static final int Col_AddressLastName= 8;
	public static final int Col_Company= 9;
	public static final int Col_AddressLine2= 10;
	public static final int Col_City= 11;
	public static final int Col_State= 12;
	public static final int Col_AditionalInfo= 13;
	public static final int Col_MobilePhone= 15;
	public static final int Col_AddressAlias= 16;
	public static final int Col_ResultResponse = 17;
	public static final int Col_ExpectedResponse =18;

	//Test Data Sheet sheetOrderClothes
	public static final int Col_setTestCaseNameOrderClothes = 0;	
	public static final int Col_ClothingName = 1;
	public static final int Col_SetBrowserOrderClothes = 2;
	public static final int Col_SetExpectedResultOrderClothes = 3;
	public static final int Col_SetResultOrderClothes = 4;
	

	// Path to the Screenshot files
	public static final String Path_ScreenShot = "./evidences/";
}
