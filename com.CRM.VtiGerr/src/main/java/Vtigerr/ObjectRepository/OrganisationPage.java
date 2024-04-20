package Vtigerr.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	@FindBy(xpath="//img[contains(@title,'Create Organization')]") private WebElement orgLookupImg;
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickorglookUpImg()
	{
		orgLookupImg.click();
	}


}
