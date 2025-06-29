package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCartPage extends BasePage
{

	public AddCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Search - iPhone']")
	WebElement headerSearch;
	
	@FindBy(xpath = "//i[@class='fa fa-th-list']")
	WebElement btnChangeListFormat;
	
	@FindBy(xpath = "//div[@class='product-layout product-list col-xs-12']//button[1]")
	WebElement btnAddCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement cartSuccessMsg;
	
	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement btnAddCartItem;
	
	@FindBy(xpath = "//strong[normalize-space()='View Cart']")
	WebElement btnViewCart;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")
	WebElement checkProductAdded;
	
	
	
	public String serchHeader()
	{
		return headerSearch.getText();
	}
	
	public void clickToChangeListFormat()
	{
		btnChangeListFormat.click();
	}
	
	public void clickAddCart()
	{
		btnAddCart.click();
	}
	
	public String cartSuccessMessage()
	{
		return cartSuccessMsg.getText();
	}
	
	public void clickBtnAddCartItem()
	{
		btnAddCartItem.click();
	}
	
	public void clickBtnViewCart()
	{
		btnViewCart.click();
	}
	
	public String checkProductAdded()
	{
		return checkProductAdded.getText();
	}
	
}
