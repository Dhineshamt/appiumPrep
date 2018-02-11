package appium.appiumPrep;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;


public class EnableWIFI {
	AndroidDriver<WebElement> driver;
	

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		AndroidDriver<WebElement> driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "abcd");
		capability.setCapability("platformName", "Android");
		capability.setCapability("appPackage", "com.asus.message");
		capability.setCapability("appActivity", "com.android.mms.ui.ConversationList");		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);		
	}
	
	@Test
	public void enableWifi() {
		driver.setConnection(Connection.WIFI);
	}

}
