package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AddCartPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC004_AddToCart extends BaseClass 
{
	int addCartStatus=0;
	//AddCartPage acp=new AddCartPage(driver);
	
	@Test(priority=1)
	public void testAddToCart()
	{
		
		MyAccountPage map=new MyAccountPage(driver);
		
		//map.searchItem(properties.getProperty("searchProductName"));
		map.searchItem("iPhone");

		map.clickBtnSearch();
		
		AddCartPage acp=new AddCartPage(driver);
		String serchHeaderValue=acp.serchHeader();
		acp.clickToChangeListFormat();
		
		
		//Assert.assertEquals(serchHeaderValue, "Search - iPhone");
		
		
		if(serchHeaderValue.equals("Search - iPhone"))
		{
			Assert.assertTrue(true);
			System.out.println(serchHeaderValue);
			
			acp.clickAddCart();
			
			String cartMessageValue=acp.cartSuccessMessage();
			System.out.println(cartMessageValue);
			
			if(cartMessageValue.contains("Success"))
			{
				addCartStatus=1;
				Assert.assertTrue(true);
				
			}
			else
			{
				logger.info("Item Not added");
				Assert.assertTrue(false);
			}
		}
		else
		{
			logger.info("Invalid Search");
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(priority=2)
	public void testCheckProductAdded()
	{
		AddCartPage acp=new AddCartPage(driver);
		
		if(addCartStatus==1)
		{
			acp.clickBtnAddCartItem();
			acp.clickBtnViewCart();
			String productAdded=acp.checkProductAdded();
			
			if(productAdded.equals("iPhone"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("No Item added with Such Name");
				Assert.assertTrue(false);
			}
		}
		
	}
}
