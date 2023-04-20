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

import io.appium.java_client.android.AndroidDriver;

public class TestngCalc {
	
	public static AndroidDriver driver;

	
	@BeforeClass
	private void appopn() throws MalformedURLException {
		
		
		
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
	private void date() throws InterruptedException {
		java.util.Date d = new java.util.Date();
		System.out.println("Tast Started on : "+d);
		
		
		

	}
	
	@AfterMethod
	private void dateaft() {
		java.util.Date d = new java.util.Date();
		System.out.println("Tast Completed on : "+d);

	}
		
	
	@Test
	private void tst1() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement checkbox = driver.findElement(By.id("android:id/checkbox"));
		checkbox.click();
		WebElement agree = driver.findElement(By.id("android:id/button1"));
		agree.click();
		
		Thread.sleep(3000);
			
		WebElement svnBtn = driver.findElement(By.id("com.miui.calculator:id/btn_7_s"));
		svnBtn.click();

	}
	
	
	@Test
	private void tst2() throws InterruptedException {
		Thread.sleep(1000);
		WebElement twoBtns = driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
		twoBtns.click();
		
		WebElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
		plus.click();

	}
	
	@Test
	private void tst3() {
		
		WebElement nineBtn = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
		nineBtn.click();
		
		WebElement fivBtn = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
		fivBtn.click();
		
		
	}
		
	@Test
	private void tst4() {
		WebElement equals = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"equals\"]"));
		equals.click();

	}
	
	
	@AfterMethod
	private void screensh() throws IOException {
		TakesScreenshot sh = (TakesScreenshot)driver;
		
		File sa = sh.getScreenshotAs(OutputType.FILE);
		File location = new File("C:\\Users\\Nitheesh K N\\eclipse-workspace\\Appiumc\\screenshots\\calc.png");
		FileUtils.copyFile(sa, location);

	}
	
	
	@AfterClass
	private void closeapp() {
		driver.quit();

	}
		
	

}
