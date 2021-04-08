package com.qa.lumen.main;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.Login;
import Pages.SIGNOUT;

public class Lightings extends Basepage {; 
	public Lightings() throws IOException {
		super();
	}
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeTest
	public void StartTest()
	{
	//.....EXTENT REPORTS.....//
		ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/test-output4/LightingsnewReport.html");
			 ExtentTest test =report.startTest("Lightings");
	}
	@BeforeMethod
	@Parameters("browser")
   public void Start_initialization(String browser) throws IOException {
		
		//
		OpenBrowser(browser);
		//
		GetURL(config.getProperty("URL"));
		Login login= new Login();
		  login.Loginpage();
	}
	
		
	@Test(priority=1)
	public void Lighting() throws IOException {
	 Reporter.log("Lighting",true);
	 
		     //.....Lightings...//
	 
	 Actions a1 = new Actions(driver);
	  a1.moveToElement(driver.findElement(By.xpath("//span[@title='lighting']"))).perform();
	  Reporter.log("lighting ",true);
	}
	
	 @Test (priority = 3,enabled = false)
	 public void Mousehover() throws IOException
	   {
		 Reporter.log("Mousehover",true);
		  WebElement ele = driver.findElement(By.xpath("//b[text()='Shop Ceiling Lights']"));
		  System.out.println("The header text is - " +ele.getText());
		  
		   
		  //...Action class..//

     Actions a2 = new Actions(driver);
	 a2.moveToElement(driver.findElement(By.xpath(" //span[@title='fans']"))).perform();
	 Reporter.log("fans ",true);	
			  
     Actions a3 = new Actions(driver);
	 a3.moveToElement(driver.findElement(By.xpath(" //span[@title='rooms']"))).perform();
	 Reporter.log("rooms",true); 
		     

	} 
	
  @Test(priority=2)
	public void Ceiling() throws IOException {
	 Reporter.log("Ceiling",true);
	 Lightings lighting =new Lightings();
	 lighting.Lighting();
		 
	 //...Take screenshot...//
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File source = ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(source, new File("./Screenshots/Screenlight.png"));
	  System.out.println("Screenshot taken");
	
		 
	 //...Ceiling....//
	 Click(driver, org.getProperty("Ceiling"));
		//Click(driver, org.getProperty("view"));
			
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,150)", "");
	
    	//....Chandeliers...//
	  Click(driver, org.getProperty("chandeliers"));
			 Reporter.log("chandeliers",true);
		
		//......Large chandeliers....//	
	    WebDriverWait wait=new WebDriverWait(driver, 05);
		  WebElement Largechandeliers;
		Largechandeliers= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"main\"]/div[2]/div[2]/div[4]/div[2]/div[1]/div/div/h3/a/span")));
		Largechandeliers.click();
		 Reporter.log("Largechandeliers",true);
	    
			  //....checkbox...//
		WebElement check = driver. findElement(By.xpath("//span[text()='1 business day']")); 
		 check. click();
		 Reporter.log("check",true);
	 
		 //...Add to cart...//
		 WebDriverWait wait2=new WebDriverWait(driver, 10);
		 WebElement product = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"3e9a7c486322dc9b0cb0c7b740\"]/div[1]/div[4]/a"))); 
		  product. click();
		  //.....CART....//

		 WebDriverWait wait3=new WebDriverWait(driver, 05);
		 WebElement button = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@id='add-to-cart'])[1]"))); 
			 button. click();
			 
			 //.....CHECKOUT....//
		 WebDriverWait wait4=new WebDriverWait(driver, 05);
		 WebElement checkoutt = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'CHECKOUT')]"))); 
		   checkoutt. click();
		
	    //...REMOVE PRODUCT...//
		  WebElement remove = driver. findElement(By.xpath("(//span[text()='Remove'])[1]")); 
		  remove. click();
		  Reporter.log("remove",true);
		  
		SIGNOUT signoutT= new SIGNOUT();
		  signoutT.signout();	        
			    
	    driver.findElement(By.xpath("//a[@class='ltkpopup-close']")).click(); 
				    try {
			 Thread.sleep(4000);
			   } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
		   e.printStackTrace();
		    }
				    
		   test.log(LogStatus.PASS, "TEST PASSED");
		   test.log(LogStatus.FAIL, "TEST FAILED");
           test.log(LogStatus.SKIP, "TEST SKIPPED");
		   test.log(LogStatus.INFO, "TEST INFO");

	}
	 
	  
 @AfterClass
  public static void endTest()
	 {
	     report.endTest(test);
	     report.flush();

           
}}
