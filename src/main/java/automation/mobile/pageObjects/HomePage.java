package automation.mobile.pageObjects;



import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

import utils.AndroidActions;

/**
 * Hello world!
 *
 */
public class HomePage extends AndroidActions
{
	private AndroidDriver driver;
	public HomePage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	@FindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	WebElement countryDropdown;
	
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	WebElement nameField;
	
	@FindBy(id="com.androidsample.generalstore:id/toolbar_title")
	WebElement homePageTitle;
	
	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	WebElement femaleRb;
	
	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	WebElement maleRb;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	WebElement submitButton;
	
	
//	public WebElement getNameField() {
//		WebElement nameField=driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
//		return nameField;
//	}
//	public WebElement getHomePageTitle() {
//	WebElement homePageTitle=driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
//		return homePageTitle;
//	}



	public void setNameField(String name) throws InterruptedException
	{
		Thread.sleep(10000);
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	public void setGender(String gender)
	{
		if(gender.contains("female"))
		{
			femaleRb.click();
		}
		else
		{
			maleRb.click();
		}
	}
	
	public void selectCountry(String country)
	{
		countryDropdown.click();
		scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
	
	public ProductsPage submit()
	{
		submitButton.click();
		return new ProductsPage(driver);
	}
	
   
}
