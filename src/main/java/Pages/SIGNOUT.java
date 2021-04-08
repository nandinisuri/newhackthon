package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.lumen.main.Basepage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SIGNOUT extends Basepage{
	 public SIGNOUT() throws IOException {
		   super();
	   }

		@BeforeMethod
		@Parameters("browser")

		public void Start_initialization(String browser) {
			
			//
			OpenBrowser(browser);
			//
			GetURL(config.getProperty("URL"));
		}
			
@Test
public void signout  () throws IOException {
		
	//.....EXTENT REPORTS.....//
	ExtentReports ex = new ExtentReports(System.getProperty("user.dir")+"/test-output3/signoutnewReport.html");
	 ExtentTest test =ex.startTest("signout");
	 
	 Login login= new Login();
     login.Loginpage();
	 
	 Actions a = new Actions(driver);
     a.moveToElement(driver.findElement(By.xpath("//div[@class='btn-group dropdown-group']"))).perform();
       Reporter.log("account ",true);
       Click(driver,org.getProperty("signout"));
       test.log(LogStatus.PASS, "TEST PASSED");

       

       ex.endTest(test);
        ex.flush();
	
	
	
	
	
}
}