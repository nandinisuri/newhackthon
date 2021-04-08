package Pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
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

public class Registration extends Basepage {
   public Registration() throws IOException {
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
		public void Register() {
			 Reporter.log("Register",true);

				//.....EXTENT REPORTS.....//
			ExtentReports ex = new ExtentReports(System.getProperty("user.dir")+"/test-output2/registrationnewReport.html");
			 ExtentTest test =ex.startTest("registration");
			 
				 
			Sendkeys(driver, org.getProperty("FirstName"), config.getProperty("firstname"));
			Sendkeys(driver, org.getProperty("LastName"), config.getProperty("lastname"));
			Sendkeys(driver, org.getProperty("Email"), config.getProperty("email"));
			//Sendkeys(driver, org.getProperty("Phone"), config.getProperty("phone"));
			Sendkeys(driver, org.getProperty("confirmemail"), config.getProperty("cemail"));

			Sendkeys(driver, org.getProperty("PassWord"), config.getProperty("PASSWORD"));
			Sendkeys(driver, org.getProperty("CPassWord"), config.getProperty("cpassword"));
			Click(driver, org.getProperty("Caccount"));
			
			 test.log(LogStatus.PASS, "TEST PASSED");

		        

	          ex.endTest(test);
	           ex.flush();
			
		}
		



}
