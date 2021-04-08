package com.qa.lumen.main;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.Login;

public class Loginpagetest extends Basepage {

	public Loginpagetest() throws IOException {
		super();
	}
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeTest
	public void StartTest()
	{
	//.....EXTENT REPORTS.....//
		ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/test-output11/loginpnewReport.html");
			 ExtentTest test =report.startTest("Loginpagetest");
	}
	@BeforeMethod
	@Parameters("browser")
   public void Start_initialization(String browser) throws IOException {
		
		//
		OpenBrowser(browser);
		//
		GetURL(config.getProperty("URL"));
		
	}
	@Test(priority=1)
	public void loginPageTitleTest() throws IOException{
		Login login= new Login();
		  login.Loginpage();
		  String expectedTitle = "Modern Lighting, Ceiling Fans, Furniture & Home Decor | Lumens.com";
		  String actualTitle = driver.getTitle();
		  Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test(priority=2)
	public void loginPageTitlet() throws IOException{
		Login login= new Login();
		  login.Loginpage();
		  String expectedTitle = "Modern Lighting, Ceilin Fans, Furniture & Home Decor | Lumens.com";
		  String actualTitle = driver.getTitle();
		  Assert.assertEquals(actualTitle, expectedTitle);
		  test.log(LogStatus.PASS, "TEST PASSED");
		   test.log(LogStatus.FAIL, "TEST FAILED");
          test.log(LogStatus.SKIP, "TEST SKIPPED");
		   test.log(LogStatus.INFO, "TEST INFO");
		   
	}
	@AfterMethod

		   public void tearDown(ITestResult result)

		   {

		   // Here will compare if test is failing then only it will enter into if condition

		   if(ITestResult.FAILURE==result.getStatus())

		   {

		   try

		   {

		   // Create refernce of TakesScreenshot

		   TakesScreenshot ts=(TakesScreenshot)driver;

		   // Call method to capture screenshot

		   File source=ts.getScreenshotAs(OutputType.FILE);

		   // Copy files to specific location here it will save all screenshot in our project home directory and

		   // result.getName() will return name of test case so that screenshot name will be same

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




