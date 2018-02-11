package appium.appiumPrep;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class HybridApp {
	AndroidDriver<WebElement> driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "12345");
		capability.setCapability("platformName", "Android");
		capability.setCapability("appPackage", "com.testleaf.leaforg");
		capability.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);	
		wait = new WebDriverWait(driver,10);
	}
	
	@Test 
	public void getContext() throws InterruptedException {
		Thread.sleep(5000);
		Set<String> contextNames = driver.getContextHandles();
		for(String contextName: contextNames)
		{
			
			if(contextName.contains("WEBVIEW"))
			{
				driver.context(contextName);
				System.out.println(contextName);
			}
		}
		
		//driver.context("NATIVEAPP");
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='email']")));		
		driver.findElementByXPath("//input[@formcontrolname='email']").sendKeys("rajkumar@testleaf.com");
		driver.findElementByXPath("//input[@formcontrolname='password']").sendKeys("Leaf@123");
		driver.findElementByXPath("//span[contains(text(),'Login')]").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ion-icon[@class='tab-button-icon ion-md-settings']")));	
		driver.findElementByXPath("//ion-icon[@class='tab-button-icon ion-md-settings']").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ion-label[contains(text(),'My Profile')]")));
		driver.findElementByXPath("//ion-label[contains(text(),'My Profile')]").click();
								   	
		driver.findElementByXPath("//input[@formcontrolname='lname']").clear();
		driver.findElementByXPath("//input[@formcontrolname='lname']").sendKeys("Dhinesh");
		
		driver.findElementByXPath("//span[contains(text(),'SAVE CHANGES')]").click();
		
		
		driver.findElementByXPath("//span[contains(text(),'OK')]").click();
			
		Thread.sleep(5000);
		
		driver.quit();
		
		
	}
	
	/*@Test
	public void editProfile() throws InterruptedException 
	{
		
		
		
		
	}*/
	
	
	

}
