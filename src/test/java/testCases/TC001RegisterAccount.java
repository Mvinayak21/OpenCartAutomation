package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.BaseClass;

public class TC001RegisterAccount extends BaseClass
{
  	
	@Test(groups={"Sanity","Master"})
	public void verifyRegistration()
	{
		try {
		logger.info("****Starting TC001 Test Case ****");
		HomePage hp = new HomePage(driver);
		hp.clickBtnMyAccount();
		logger.info("Clicked on My Account ");
		
		hp.clickBtnRegister();
		logger.info("Clicked on Register ");
		
		RegistrationPage rp = new RegistrationPage(driver);
		
		logger.info("Providing Customer Details");
		//rp.setFirstName("Vinayak");
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		
		String email=randomString()+"@test.com";
//		System.out.println("EmailID : "+email);
		rp.setEmail(email);
		rp.setTelephone(randomNumber());
		
		String psw = randomAlphaNumeric();
//		System.out.println("Password : "+psw);
		rp.setPassword(psw);
		rp.setConfirmPassword(psw);
		rp.checkAgree();
		rp.clickSubmit();
		
		String sucMessage = rp.getMessage();
		
		logger.info("validating expected results");
		System.out.println(sucMessage);
		
		if(sucMessage.equals("Your Account Has Been Created!"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		Assert.assertEquals(sucMessage, "Your Account Has Been Created!");
		}
		catch (Exception e) 
		{
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			Assert.fail();
		}
		
		logger.info("Finished TC001 Account Registration");
	}
	
	
	
}

