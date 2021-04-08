package com.qa.lumen.main;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.Login;

public class failingtest extends Basepage{
	
	public failingtest() throws IOException {
		super();
	}
	static ExtentTest test;
	static ExtentReports report;

	@BeforeMethod
	@Parameters("browser")
   public void Start_initialization(String browser) {
		
		//
		OpenBrowser(browser);
		//
		GetURL(config.getProperty("URL"));
	}
		
		@Test
		public void Addproduct() throws IOException, InterruptedException {
			 Reporter.log("Addproduct",true);
    	//.....EXTENT REPORTS.....//
		 ExtentReports ex = new ExtentReports(System.getProperty("user.dir")+"/test-output5/addproductnewReport.html");
		  ExtentTest test =ex.startTest("Addproduct");
		 
			 Login login= new Login();
		     login.Loginpage();
		     
		     Lightings lightings=new Lightings();
		     lightings.Lighting();
		           
	      WebElement ele = driver.findElement(By.xpath("//b[text()='Shop Ceiling Lights']"));
		  System.out.println("The header text is - " +ele.getText());
					

		   Actions a2 = new Actions(driver);
		   a2.moveToElement(driver.findElement(By.xpath(" //span[@title='fans']"))).perform();
		   Reporter.log("fans ",true);
		 			       
		   Actions a3 = new Actions(driver);
		   a3.moveToElement(driver.findElement(By.xpath(" //span[@title='room']"))).perform();
		   Reporter.log("rooms",true); 
			 
			 test.log(LogStatus.FAIL, "TEST Failed");

             test.log(LogStatus.PASS, "TEST PASSED");
		}
	 @AfterMethod

	  public void tearDown(ITestResult result)

			 {
				 if(ITestResult.FAILURE==result.getStatus())
			 {

			 try
	        {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		   File source=ts.getScreenshotAs(OutputType.FILE);

		   FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));

		   System.out.println("Screenshot taken");

		   }

		   catch (Exception e)

		   {

		   System.out.println("Exception while taking screenshot "+e.getMessage());

		   }

		   }
		   report.endTest(test);
           report.flush();
	
	
}}
