package automation.mobile.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import utils.AndroidActions;

public class CartPage extends AndroidActions {
	AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	List<WebElement> productPrice;
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	WebElement total;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	WebElement proceedButton;
	
	
	@FindBy(className="android.widget.CheckBox")
	WebElement checkBox;
	
	@FindBy(id="com.androidsample.generalstore:id/termsButton")
	WebElement terms;
	
	@FindBy(id="android:id/button1")
	WebElement acceptButton;
	
	public double getProductSum()
	{
		int size=productPrice.size();
		double sum=0;
		for(int i=0;i<size;i++)
		{
			String amount=productPrice.get(i).getText();
			Double price=getFormattedAmount(amount);
			sum=sum+price;
			
		}
		return sum;
	}


	public Double getTotal()
	{
		return getFormattedAmount(total.getText());
	}
	
	public void clickCheckBox()
	{
		checkBox.click();
	}
	public void accepTtermasAndCondition()
	{
		longPressAction(terms);
		acceptButton.click();
	}
	
	public void proceedToBuy()
	{
		proceedButton.click();
	}
	
	
	



}
