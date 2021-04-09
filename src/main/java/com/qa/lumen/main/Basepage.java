package com.qa.lumen.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Basepage {
	public static WebDriver driver;
	public static Properties config = new Properties();
	FileInputStream fig_config,fig_org;
	public static Properties org = new Properties();



	public Basepage() throws IOException  {
		fig_config = new FileInputStream("./resource/config.properties");
		config.load(fig_config);
		fig_org =new FileInputStream("./resource/org.properties");
		org.load(fig_org);
	}

public void OpenBrowser(String browser) {
		
		
		if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "E:\\seleniumFiles\\Drivers\\chromedriver_win32\\chromedriver.exe");
			 
			  driver =new ChromeDriver();  
			
		}

        else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\seleniumFiles\\Drivers\\geckodriver.exe");
			
			  driver =new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
}
		
		public void GetURL(String url) {
			
			try {
				driver.get(url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void Click(WebDriver driver,String xpath) {
			
			try {
				driver.findElement(By.xpath(xpath)).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void Sendkeys(WebDriver driver,String xpath,String value) {
			
			try {
				driver.findElement(By.xpath(xpath)).sendKeys(value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		//take screenshot
	
		  public String filePath = "/hackthon03/Screenshots";
		    public void onTestFailure(ITestResult result) {
		    	System.out.println("***** Error "+result.getName()+" test has failed *****");
		    	String methodName=result.getName().toString().trim();
		        ITestContext context = result.getTestContext();
		       WebDriver driver = (WebDriver)context.getAttribute("driver");
		    	takeScreenShot(methodName, driver);
		    }
		    
		    public void takeScreenShot(String methodName, WebDriver driver) {
		    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		         //The below method will save the screen shot in d drive with test method name 
		            try {
						FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
						System.out.println("***Placed screen shot in "+filePath+" ***");
					} catch (IOException e) {
						e.printStackTrace();
					}
		    }
		 			// driver is interacting
		public void Actions(WebDriver driver,String xpath) {
			Actions a = new Actions(driver);
		    a.moveToElement(driver.findElement(By.xpath(xpath))).perform();
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
		    public void Scroll() {
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0,1000)", "");
		        
		        
		       
			
			
		}
		    
		
		
		
		
}