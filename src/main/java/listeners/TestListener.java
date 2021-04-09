package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
	@Override
	 public void onFinish(ITestContext result) {
		
		
	  
	 }

	 @Override
	 public void onStart(ITestContext result) {
	 System.out.println("Test onstart and details "+result.getName());

 
	 }

	 @Override
	 public void onTestFailure(ITestResult result) {
	 System.out.println("Test Failed and details "+result.getName());
	  
	 }

	 @Override
	 public void onTestSkipped(ITestResult result) {
	System.out.println("Test Skipped and details "+result.getName());

	 }

	 @Override
	 public void onTestStart(ITestResult result) {
	 System.out.println("Test Start and details "+result.getName());

	  
	 }

	 @Override
	 public void onTestSuccess(ITestResult result) {
	 System.out.println("Test passed and details "+result.getName());
	  
	 }

	}
