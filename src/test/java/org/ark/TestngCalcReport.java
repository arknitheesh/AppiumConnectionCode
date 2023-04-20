package org.ark;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.appium.java_client.android.AndroidDriver;

public class TestngCalcReport {
	
	public static AndroidDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports repo ;
	ExtentTest et ;
	
	
	@BeforeClass
	private void appopn() throws MalformedURLException {
		
		htmlreport = new ExtentHtmlReporter("C:\\Users\\Nitheesh K N\\eclipse-workspace\\Appiumc\\Reports\\calcreport.html");  
		repo = new ExtentReports();
		repo.attachReporter(htmlreport);
		et = repo.createTest("Android", "Calculator");
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("deviceName", "CPH2387");
		cap.setCapability("udid", "LRMFDQA6AASWJREY");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		driver = new AndroidDriver(url, cap);

	}
	
	@BeforeMethod
	private void date() {
		
		java.util.Date d = new java.util.Date();
		System.out.println("Tast Started on : "+d);
		et.log(Status.INFO, "APP Test Started : " + d );
	}
	
	@AfterMethod
	private void dateaft() {
		java.util.Date d = new java.util.Date();
		System.out.println("Tast Completed on : "+d);
		et.log(Status.INFO, "APP Test Completed : " + d );
	}
		
	
	@Test
	private void tst1() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement checkbox = driver.findElement(By.id("android:id/checkbox"));
		checkbox.click();
		WebElement agree = driver.findElement(By.id("android:id/button1"));
		agree.click();
		
		
		Thread.sleep(3000);
		et.log(Status.PASS, "Button 7 Clicked");	
		WebElement svnBtn = driver.findElement(By.id("com.miui.calculator:id/btn_7_s"));
		svnBtn.click();

	}
	
	
	@Test
	private void tst2() {
		et.log(Status.PASS, "Button Two Clicked");
		WebElement twoBtns = driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
		twoBtns.click();
		
		et.log(Status.PASS, "Button Plus  Clicked");
		WebElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
		plus.click();

	}
	
	@Test
	private void tst3() {
		et.log(Status.PASS, "Button 9 Clicked");
		WebElement nineBtn = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
		nineBtn.click();
		
		et.log(Status.PASS, "Button 5 Clicked");
		WebElement fivBtn = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
		fivBtn.click();
		
		
	}
		
	@Test
	private void tst4() {
		et.log(Status.PASS, "Button = Clicked");
		WebElement equals = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"equals\"]"));
		equals.click();

	}
	
	
	@AfterMethod
	private void screensh() throws IOException {
		
		et.log(Status.INFO, "SCREENSHOT TAKED");
		TakesScreenshot sh = (TakesScreenshot)driver;
		
		File sa = sh.getScreenshotAs(OutputType.FILE);
		File location = new File("C:\\Users\\Nitheesh K N\\eclipse-workspace\\Appiumc\\screenshots\\calc.png");
		FileUtils.copyFile(sa, location);

	}
	
	
	@AfterClass
	private void closeapp() {
		
		et.log(Status.PASS, "Test Completed App Closed");
		repo.flush();
		driver.quit();

	}
		
	

}
