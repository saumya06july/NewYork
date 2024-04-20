package Vtigerr.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	@FindBy(name = "lastname") private WebElement lastnameEdt;
	@FindBy(name = "button")private WebElement savebutton;
	
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Createcontact(String contactname)
	{
		lastnameEdt.sendKeys(contactname);
		savebutton.click();
	}

}
