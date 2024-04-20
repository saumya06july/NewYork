package Vtigerr.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisationPage {

	@FindBy(name="accountname")private WebElement Orgtext;
	@FindBy(name="button")
	private WebElement SaveButton;
	
	public CreateNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void Createorg(String orgName)
	{
		Orgtext.sendKeys(orgName);
		SaveButton.click();
	}
	
}
