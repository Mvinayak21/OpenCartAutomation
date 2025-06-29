package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage
{
	
	public  RegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(name="firstname")
	WebElement textFirstName;
	
	@FindBy(name="lastname")
	WebElement textLastName;
	
	@FindBy(name="email")
	WebElement textEmail;
	
	@FindBy(name="telephone")
	WebElement textTelephone;
	
	@FindBy(name="password")
	WebElement textPassword;
	
	@FindBy(name="confirm")
	WebElement textConfirmPassword;
	
	@FindBy(name = "agree")
	WebElement chkAgree;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btnSubmit;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement successMessage;
	
//	Your Account Has Been Created!
	
	public void setFirstName(String firstname)
	{
		textFirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname)
	{
		textLastName.sendKeys(lastname);
	}
	
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		textTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String ConfPassword)
	{
		textConfirmPassword.sendKeys(ConfPassword);
	}
	
	public void checkAgree()
	{
		chkAgree.click();
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public String getMessage()
	{
		return successMessage.getText();
	}

}
