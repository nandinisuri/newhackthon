package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.lumen.main.Basepage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends Basepage {
	
	public Login() throws IOException {
	super();
	
}
	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	public void extent() {
	//.....EXTENT REPORTS.....//
	ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/test-output1/LoginnewReport.html");
	 ExtentTest test =report.startTest("Login");
	}
	@BeforeMethod
	@Parameters("browser")
   public void Start_initialization(String browser) {
		
		//
		OpenBrowser(browser);
		//
		GetURL(config.getProperty("URL"));
	}
		
@Test(priority=1)
	public void Loginpage()
       {
	 Reporter.log("Loginpage",true);
	 Sendkeys(driver, org.getProperty("username"), config.getProperty("Username"));
	 Reporter.log("username",true);
     Sendkeys(driver, org.getProperty("Password"), config.getProperty("Pwd"));
	 Reporter.log("username",true);
     Click(driver, org.getProperty("Loginbutton"));
		}
				
@Test(priority=2)
		public void loginPageTitleTest() throws IOException{
		Login login= new Login();
		 login.Loginpage();
		 String expectedTitle = "Modern Lighting, Ceiling Fans, Furniture & Home Decor | Lumens.com";
		 String actualTitle = driver.getTitle();
		 System.out.println("expectedTitle" + actualTitle);   
         Assert.assertEquals(actualTitle, expectedTitle);
		 Reporter.log("LoginpageTitleTest",true);
		 
	
		 test.log(LogStatus.PASS, "TEST PASSED");
		   test.log(LogStatus.FAIL, "TEST FAILED");
         test.log(LogStatus.SKIP, "TEST SKIPPED");
		   test.log(LogStatus.INFO, "TEST INFO");
		          report.endTest(test);
		           report.flush();
				
				
		}
	
	

}
