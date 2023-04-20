package org.ark;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class calculator {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("deviceName", "CPH2387");
		cap.setCapability("udid", "LRMFDQA6AASWJREY");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		driver = new AndroidDriver(url, cap);
		
		Thread.sleep(3000);
		
		
		
		WebElement oneBtn = driver.findElement(By.id("com.miui.calculator:id/btn_1_s"));
		oneBtn.click();
		
		WebElement twoBtns = driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
		twoBtns.click();
		
		WebElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
		plus.click();
		
		WebElement nineBtn = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
		nineBtn.click();
		
		WebElement equals = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"equals\"]"));
		equals.click();
		
		
	}

}
