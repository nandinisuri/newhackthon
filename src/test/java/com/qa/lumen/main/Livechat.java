package com.qa.lumen.main;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Pages.Login;

public class Livechat extends Basepage {
	public Livechat() throws IOException {
		super();
	}
	@BeforeMethod
	@Parameters("browser")
   public void Start_initialization(String browser) {
		
		//
		OpenBrowser(browser);
		//
		GetURL(config.getProperty("URL1"));
	}
		
		@Test
		public void Live() throws IOException, InterruptedException {
			 Reporter.log("Live",true);

				//.....EXTENT REPORTS.....//
			ExtentReports ex = new ExtentReports(System.getProperty("user.dir")+"/test-output6/LivenewReport.html");
			 ExtentTest test =ex.startTest("Live");
			
			 Login login= new Login();
		     login.Loginpage();
		     
		     Actions a1 = new Actions(driver);
		     a1.moveToElement(driver.findElement(By.xpath("//div[text()='Live Chat']"))).perform();
			 Click(driver, org.getProperty("//div[text()='Live Chat']"));
			 Sendkeys(driver, org.getProperty("name"), config.getProperty("Name"));
			 Click(driver, org.getProperty("submit"));

			 
			 
		    
		     
		     

}}
