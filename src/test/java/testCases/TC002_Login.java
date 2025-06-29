package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AddCartPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;


public class TC002_Login extends BaseClass 
{
	@Test(groups= {"Master","Regression"})
	public void testLogin()
	{
		logger.info("*** TC002 Started ***");
		try 
		{
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickBtnMyAccount();
			hp.clickBtnLogin();
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(properties.getProperty("emilId"));
			lp.setPassword(properties.getProperty("password"));
			lp.clickLogin();
			
			String resLogo = lp.getLogo();
			Assert.assertEquals(resLogo, "Qafox.com");
			
			//MyAccountPage
			MyAccountPage map = new MyAccountPage(driver);
			
			boolean targetPage=map.myAccountHeader();
			Assert.assertTrue(targetPage);
			
		}
		catch (Exception e) 
		{
			logger.info("Test Failed");
			Assert.fail();
		}
		
		logger.info("*** TC002 Ended ***");
	}
	
//	@Test(priority = 2)
//	public void testAddToCart()
//	{
//		MyAccountPage map=new MyAccountPage(driver);
//		
//		map.searchItem(properties.getProperty("searchProductName"));
//		map.clickBtnSearch();
//		
//		AddCartPage acp=new AddCartPage(driver);
//		
//		String serchHeaderValue=acp.serchHeader();
//		acp.clickToChangeListFormat();
//		
//		//Assert.assertEquals(serchHeaderValue, "Search - iPhone");
//		
//		
//		if(serchHeaderValue.equals("Search - iPhone"))
//		{
//			Assert.assertTrue(true);
//			System.out.println(serchHeaderValue);
//			
//			acp.clickAddCart();
//			
//			String cartMessageValue=acp.cartSuccessMessage();
//			System.out.println(cartMessageValue);
//			
//			if(cartMessageValue.contains("Success"))
//			{
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				Assert.assertTrue(false);
//			}
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
//	}

}
