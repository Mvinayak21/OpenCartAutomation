package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement headerName;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement linkLogout;
	
//	@FindBy(xpath = "//ul[@class='breadcrumb']/li[1]/a")
//	WebElement linkHome;
	
	@FindBy(xpath = "//*[@name='search']")
	WebElement searchArea;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch; 
	
	
	public boolean myAccountHeader()
	{
		try {
		return headerName.isDisplayed();
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	
//	public void clickHome()
//	{
//		linkHome.click();
//	}
	
	public void searchItem(String item)
	{
		searchArea.sendKeys(item);
	}
	
	public void clickBtnSearch()
	{
		btnSearch.click();
	}
	
	

}
