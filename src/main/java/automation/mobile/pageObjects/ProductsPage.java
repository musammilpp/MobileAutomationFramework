package automation.mobile.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import utils.AndroidActions;

public class ProductsPage extends AndroidActions{
	
	
	private AndroidDriver driver;
	public ProductsPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_back")
	WebElement backButton;
	
	@FindBy(id="com.androidsample.generalstore:id/toolbar_title")
	WebElement title;
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	WebElement cart;
	
	@FindBy(xpath ="//android.widget.TextView[@text='ADD TO CART']")
	List<WebElement> addCart;
	
	public void addToCartByIndex(int index)
	{
		addCart.get(index).click();;
	}
	public CartPage clickcart()
	{
		cart.click();
		return new CartPage(driver);
	}

}
