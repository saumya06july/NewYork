package Vtigerr.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement ContactLookupImg;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickcontactlookupimg()
	{
		ContactLookupImg.click();
	}

}
