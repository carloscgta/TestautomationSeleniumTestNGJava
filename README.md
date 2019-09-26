# Testautomation
 Selenium Framework built using Java with Selenium and TestNG

alpha-sense-SeleniumAutomation
Test Automation Framework using Java with Selenium WebDriver and TestNG This Framework use Maven, and all the dependecies are managed by the POM file. This Framework follow the pattern POM. There are only 3 layers: Pages, Tests and Utility. The Test data is handled by excel Datasheet.


# Settings
For creating a new Test Case is necessary firstly create a new excedata sheet with all the test Date and name the sheet with a name related to the testPage. The method: ExcelUtils.getRowContains("TestCAseName", "SheetNae") is called in every @BeforeMethod. It mandatory to pass by parameter the name of the name of the Excel file sheet. In The Constant File set the number of the collum.


The exchel file is in the path: .//src//main/resources//testData.xlsx

The screenshots and the PDF reports are saved in the folder: .//src//main//report//

The Drivers are in the folder: chromeDriver=.//src//main//drivers// 

The information about the environment, and path are stored in:
.//src//main//resources//config.uat.properties
 
Before running in another environment, check the path that are used within the framework.
For each test case, the framework generate a PDF file with the screenshots with the status of the execution.
