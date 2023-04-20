package org.ark;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("deviceName", "CPH2387");
		cap.setCapability("udid", "LRMFDQA6AASWJREY");
		cap.setCapability("appPackage", "com.myntra.android");
		cap.setCapability("appActivity", "com.myntra.android.SplashActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		driver = new AndroidDriver(url, cap);
		
		Thread.sleep(1000);
		WebElement menu = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"leftElement\"]/android.widget.TextView"));
		menu.click();
		
		Thread.sleep(2000);
		WebElement loginBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"TOPNAV_CAROUSEL_1_4\"]/android.view.ViewGroup"));
		loginBtn.click();
		
		Thread.sleep(3000);
		
		WebElement mobileNum = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"mobile\"]"));
		mobileNum.sendKeys("9946684654");
		
		WebElement login = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"form-button\"]"));
		
		
		
	}

}
