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
	 public void onFinish(ITestContext arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onStart(ITestContext arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestFailure(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestSkipped(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestStart(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void onTestSuccess(ITestResult arg0) {
	  // TODO Auto-generated method stub
	  
	 }

	}
