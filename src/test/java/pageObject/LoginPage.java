package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//*[@id='input-email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement inputPsw;
	
	@FindBy(xpath="//*[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//*[@id=\"logo\"]/h1/a")
	WebElement checkLogo;
	
	public void setEmail(String email)
	{
		inputEmail.sendKeys(email);
	}
	
	public void setPassword(String psw)
	{
		inputPsw.sendKeys(psw);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public String getLogo()
	{
		 return checkLogo.getText();
	}
	
	

}
