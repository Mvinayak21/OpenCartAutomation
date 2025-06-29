package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement btnMyAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement btnRegister;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement btnLogin;
	
	
	
	public void clickBtnMyAccount()
	{	
		btnMyAccount.click();	
	}
	
	public void clickBtnRegister() 
	{
		btnRegister.click();
	}
	
	public void clickBtnLogin()
	{
		btnLogin.click();
	}	
	
}
