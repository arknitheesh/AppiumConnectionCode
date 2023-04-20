package org.ark;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class BaseProperty {
	
	public static AndroidDriver driver;
	
	Properties property;
	
	@BeforeClass
	private void appopn() throws IOException, InterruptedException {
		
		Properties property = new Properties();
		FileInputStream fi = new FileInputStream("C:\\Users\\Nitheesh K N\\eclipse-workspace\\Appiumc\\Property\\details.properties");
		property.load(fi);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName",property.getProperty("property.getProperty(\"\")"));
		cap.setCapability("platformVersion",property.getProperty("platformVersion"));
		cap.setCapability("deviceName",property.getProperty("deviceName"));
		cap.setCapability("udid",property.getProperty("udid"));
		cap.setCapability("appPackage", property.getProperty("appPackage"));
		cap.setCapability("appActivity", property.getProperty("appActivity"));
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		driver = new AndroidDriver(url, cap);

		
		Thread.sleep(2000);
		WebElement seleLanguage = driver.findElement(By.xpath(property.getProperty("flipLang")));
		seleLanguage.click();
		
		WebElement contiBtn = driver.findElement(By.xpath(property.getProperty("contBtnID")));
		contiBtn.click();
		
		Thread.sleep(4000);
		WebElement cancel = driver.findElement(By.id(property.getProperty("CancelBtns")));
		cancel.click();
		
		Thread.sleep(2000);
		WebElement InputMob = driver.findElement(By.xpath(property.getProperty("InMobs")));
		InputMob.click();
		Thread.sleep(4000);
		InputMob.sendKeys(property.getProperty("Mobiless"));
		
	}
	
	@Test
	private void tst1() throws InterruptedException {
		
		
		Thread.sleep(2000);
		System.out.println("Test");
		
		
		
		
		
	}

}
