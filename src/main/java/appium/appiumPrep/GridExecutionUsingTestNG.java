package appium.appiumPrep;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExecutionUsingTestNG {
	
	AndroidDriver<WebElement> driver = null;


	 @BeforeMethod
	 @Parameters({"port","device","version"})
	 public void setUp(String port, String device, String version) throws MalformedURLException {		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", device);
		capabilities.setCapability("platformVersion", version);
		capabilities.setCapability("browserName", "chrome");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:"+port+"/wd/hub"), capabilities);
//		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://m.hyundai.co.in/mobile/");
		}
	

	@Test(priority = 1)
	 public void Surfing() throws InterruptedException, IOException  {
		
		 WebDriverWait waitButton = new WebDriverWait(driver, 60);
		 waitButton.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Special Offers")));
		 driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/div[5]/div[1]/div/ul/li[1]/a")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='images/CarModel/f11358fb_141x43_elite.png']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='images/logo.png']")).click();
		 WebDriverWait waitImage = new WebDriverWait(driver, 30);
	     waitImage.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Special Offers")));
	     Thread.sleep(5000);
	}
	
	
	}
