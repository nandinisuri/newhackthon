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

public class Loginpageexcel {
	
	WebDriver driver;


	@BeforeTest
	@Parameters("browser")

	 public void TestSetup(String browser) throws InterruptedException
	 
	{
	
		if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "E:\\seleniumFiles\\Drivers\\chromedriver_win32\\chromedriver.exe");
			 
			  driver =new ChromeDriver();  
			
		}

        else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","\"E:\\seleniumFiles\\Drivers");
			
			  driver =new FirefoxDriver();
		}
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
		

		}
  }


