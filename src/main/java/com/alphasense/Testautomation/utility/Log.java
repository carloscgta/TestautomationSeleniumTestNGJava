package com.alphasense.Testautomation.utility;

import org.apache.log4j.Logger;


public class Log {
	// Initialize Log4j logs
    private static Logger Log = Logger.getLogger(Log.class.getName()); 
// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
public static void startTestCase(String sTestCaseName){
   Log.info("****************************************************************************************");
   Log.info("****************************************************************************************");
   Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
   Log.info("****************************************************************************************");
   Log.info("****************************************************************************************");
   }

   //This is to print log for the ending of the test case
public static void endTestCase(String sTestCaseName){
   Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
   Log.info("X");
   Log.info("X");
   Log.info("X");
   Log.info("X");
   }

   // Need to create these methods, so that they can be called  
public static void info(String message) {
       Log.info(message);
       }
public static void warn(String message,Exception e) {
   Log.warn(message);
   }
public static void error(String message, Exception e) {
   Log.error(message);
   }
public static void fatal(String message, Exception e) {
   Log.fatal(message);
   }
public static void debug(String message, Exception e) {
   Log.debug(message);
   
	
	}
}
