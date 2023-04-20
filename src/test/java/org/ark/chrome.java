package org.ark;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;

public class chrome {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("deviceName", "CPH2387");
		cap.setCapability("udid", "LRMFDQA6AASWJREY");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		driver = new AndroidDriver(url, cap);
		
		Thread.sleep(3000);
		
		
		
		WebElement skipAccount = driver.findElement(By.id("com.android.chrome:id/signin_fre_dismiss_button"));
		skipAccount.click();
		Thread.sleep(3000);
		WebElement urls = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']"));
		urls.click();
		
		urls.sendKeys("apple phone");
		
		Robot kb = new Robot();
		
		kb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		kb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		
		
		
		
	}

}
