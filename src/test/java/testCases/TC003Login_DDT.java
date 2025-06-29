package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003Login_DDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups= {"Sanity","Regression"})
	public void verifyLogin(String email,String psw, String exp)
	{
		logger.info("*** TC003 Started ***");
		try {
		
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickBtnMyAccount();
			hp.clickBtnLogin();
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(psw);
			lp.clickLogin();
			
//			String resLogo = lp.getLogo();
//			Assert.assertEquals(resLogo, "Qafox.com");
			
			//MyAccountPage
			MyAccountPage map = new MyAccountPage(driver);
			
			boolean targetPage=map.myAccountHeader();
			Assert.assertTrue(targetPage);
			
			/*
			 Data is Valid  - Test Pass - Logout
			 				   Test Fail
			 Data is InValid - Test Fail - Logout
			 				   Test Pass 
			 */
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("InValid"))
			{
				if(targetPage==true)
				{
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
				
			}
		}
		catch(Exception ex)
		{
			Assert.assertTrue(false);
		}
		logger.info("*** TC003 Completed ***");
			
	}	

}
