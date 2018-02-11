package appium.appiumPrep;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Swipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<WebElement> driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		File targetApp = new File("D:\\Appium\\APKs\\MultiTouch Tester.apk");
		capability.setCapability("deviceName", "abcd");
		capability.setCapability("platformName", "Android");
		capability.setCapability("app", targetApp.getAbsolutePath());
		capability.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		capability.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);

		
		MobileElement elementOrder = (MobileElement) driver.findElement(By.id("com.the511plus.MultiTouchTester:id/touchStr"));
		TouchAction fingure1 = new TouchAction(driver);
		fingure1.press(elementOrder,550,920).perform().moveTo(940, 860).perform().release();
		Thread.sleep(1000);
		driver.quit();
		
	}

}
