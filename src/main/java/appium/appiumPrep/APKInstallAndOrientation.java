package appium.appiumPrep;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class APKInstallAndOrientation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<WebElement> driver;
		DesiredCapabilities capability = new DesiredCapabilities();		
		File targetApp = new File("D:\\Appium\\APKs\\LeafOrg.apk");
		capability.setCapability("deviceName", "abcd");
		capability.setCapability("platformName", "Android");
		capability.setCapability("app", targetApp.getAbsolutePath());
		capability.setCapability("appPackage", "com.testleaf.leaforg");
		capability.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		
		ScreenOrientation orientation = driver.getOrientation();
		System.out.println("By Default: "+orientation.value());
		
		if(orientation.value().contains("landscape"))
		{
			driver.rotate(ScreenOrientation.PORTRAIT);
			Thread.sleep(10000);
			System.out.println(driver.getOrientation());
		}
		
		else
		{
			driver.rotate(ScreenOrientation.LANDSCAPE);
			Thread.sleep(10000);
			System.out.println(driver.getOrientation());
		}
	}

}
