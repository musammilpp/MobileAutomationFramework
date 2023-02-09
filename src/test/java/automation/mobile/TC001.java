package automation.mobile;



import org.testng.Assert;

import org.testng.annotations.Test;

import automation.mobile.pageObjects.CartPage;
import automation.mobile.pageObjects.ProductsPage;


public class TC001 extends BaseTest{

	
	@Test
	public void testcase001() throws InterruptedException
	
	{
		
		hp.setNameField("muja");
		Thread.sleep(2000);
		hp.setGender("male");
	    hp.selectCountry("India");
	    ProductsPage pp=hp.submit();
		new ProductsPage(driver);
		
		Thread.sleep(10000);
		pp.addToCartByIndex(0);
		pp.addToCartByIndex(0);
		CartPage cp=pp.clickcart();
		//double totalSum=cp.getProductSum();
		//double displayedSum=cp.getTotal();
		//Assert.assertEquals(totalSum,displayedSum);
		cp.clickCheckBox();
		cp.accepTtermasAndCondition();
		cp.proceedToBuy();
		Assert.assertEquals("a","b");
		
		
		
	}
	
	
	
	

}
