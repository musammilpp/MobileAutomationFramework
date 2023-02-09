package automation.mobile;


import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import automation.mobile.pageObjects.HomePage;

import java.net.MalformedURLException;
import java.net.URL;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	 public HomePage hp;
	 public AndroidDriver driver;
	 @BeforeClass(alwaysRun=true)
	 public void configureAppium() throws MalformedURLException 
	 {
	
		 UiAutomator2Options options=new UiAutomator2Options();
		 options.setCapability("deviceName","Pixel6");
		// options.setCapability("app",System.getProperty("user.dir")+"/mobile/src/test/java/Resources/General-Store.apk");
		 options.setCapability("app","/Users/admin/eclipse-workspace/mobile/src/test/java/Resources/General-Store.apk");
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		 hp=new HomePage(driver);
	 
	 } 

	 @AfterClass(alwaysRun=true)
	  public void tearDown()
		{
			driver.quit();
	       
		}
	
}
