package Vtigerr.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactOrganisationInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactinfo;
	
	
	public ContactOrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String contactinfo()
	{
		return contactinfo.getText();
	
	}

}
