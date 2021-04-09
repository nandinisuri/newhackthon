package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Loginpageexcel {
	
	WebDriver driver;

	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	@Parameters("browser")
	public void extent() {
	//.....EXTENT REPORTS.....//
	ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/test-output1/LoginpagetestnewReport.html");
	 ExtentTest test =report.startTest("Loginpagetest");
	}

	 public void TestSetup(String browser) throws InterruptedException
	 
	
		{
			System.setProperty("webdriver.gecko.driver","E:\\seleniumFiles\\Drivers\\geckodriver.exe");
			 
			  driver =new FirefoxDriver();
		
	      driver.get("https://www.lumens.com/account/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	    
	}	
	@Test
	public void datadrivernlogin() throws IOException {
     
	 FileInputStream f= new FileInputStream("C:\\\\Users\\\\dell\\\\Desktop\\\\excellogin.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(f);
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		int rc=sh.getLastRowNum();
		
		String row1=sh.getRow(0).getCell(0).getStringCellValue();
		String col2=sh.getRow(1).getCell(1).getStringCellValue();
		String row2=sh.getRow(1).getCell(0).getStringCellValue();
		
		System.out.println(rc+"   "+row1+"  "+ row2+   col2 );
		driver.findElement(By.id("dwfrm_login_username")).sendKeys(row2);
		
		driver.findElement(By.name("dwfrm_login_password")).sendKeys(col2);
		driver.findElement(By.xpath("//*[@id=\"dwfrm_login\"]/fieldset/div[3]/div[2]/button")).click();
		 test.log(LogStatus.PASS, "TEST PASSED");
		   test.log(LogStatus.FAIL, "TEST FAILED");
       test.log(LogStatus.SKIP, "TEST SKIPPED");
		   test.log(LogStatus.INFO, "TEST INFO");
		          report.endTest(test);
		           report.flush();
				

		}
  }


