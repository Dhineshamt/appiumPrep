package appium.appiumPrep;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class MakeCall {
	AndroidDriver<WebElement> driver;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		File targetApp = new File("D:\\Appium\\APKs\\base.apk");
		capability.setCapability("deviceName", "abcd");
		capability.setCapability("platformName", "Android");
		capability.setCapability("app", targetApp.getAbsolutePath());
		capability.setCapability("appPackage","me.dialer.DialerOne");
		capability.setCapability("appActivity","me.dialer.DialerOne.DialerActivity" );
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
	}
	
	@Test
	public void makeCall() {
		driver.findElementById("me.dialer.DialerOne:id/name").click();
		driver.findElementByClassName("android.widget.LinearLayout").click();
		
		
	}
	

}
