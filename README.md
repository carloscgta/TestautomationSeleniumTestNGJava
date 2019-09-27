# Testautomation
 Selenium Framework built using Java with Selenium and TestNG

alpha-sense-SeleniumAutomation
Test Automation Framework using Java with Selenium WebDriver and TestNG This Framework use Maven, and all the dependecies are managed by the POM file.

This Framework follow the pattern POM. There are only 3 layers: Pages, Tests and Utility. 

The Test data is handled by excel Datasheet.


# Settings
For creating a new Test Case is necessary firstly create a new excel data sheet with all the test Date and name the sheet with a name related to the testPage.

The method: ExcelUtils.getRowContains("TestCAseName", "SheetName") is called in every @BeforeMethod.

It is mandatory to pass by parameter the name of the Excel file sheet. In The Constant File set the number of the collum.


The exchel file is in the path: .//src//main/resources//testData.xlsx

The screenshots and the PDF reports are saved in the folder: .//src//main//report//

The Drivers are in the folder: chromeDriver=.//src//main//drivers// 

The information about the environment, and path are stored in:
.//src//main//resources//config.uat.properties
 
Before running in another environment, check the path that are used within the framework.
For each test case, the framework generate a PDF file with the screenshots with the status of the execution.

# Maven Dependencies to run with profiles
  <!-- display active profile in compile phase -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-help-plugin</artifactId>
                <version>3.1.0</version>
                	
				<executions>
                    <execution>
                        <id>show-profiles</id>
                        <phase>test</phase>
                        <goals>
                            <goal>active-profiles</goal>
                        </goals>
                    </execution>
                </executions>
   
            </plugin>
			
		<plugin>
            <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.0</version>
        <configuration>
          <suiteXmlFiles>
            <suiteXmlFile>testng.xml</suiteXmlFile>
          </suiteXmlFiles>
                   
            <systemPropertyVariables>
            <env.url>${env.url}</env.url>
            
          </systemPropertyVariables>
          
        </configuration>
      </plugin>			

# Maven Profile
<profiles>

        <profile>
            <id>dev</id>
            <properties>
                <env>dev</env>
                <env.url/>
            </properties>
        </profile>

        <profile>
            <id>prod</id>
            <properties>
                <env>prod</env>
                <env.url/>
            </properties>
        </profile>

        <profile>
            <id>uat</id>
              <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <env.url>http://www.automationpractice.com/index.php</env.url>
            </properties>
        </profile>

    </profiles>

#Running with maven command line and sending by parameter the environment url

Below there is how to get the parameter from Maven command line to set the environment URL to be executed the automated tests:
String url = System.getProperty("env.url").toString();
System.out.println(url);
driver.get(url);


mvn clean test -P uat

-P activate the profile "UAT"
