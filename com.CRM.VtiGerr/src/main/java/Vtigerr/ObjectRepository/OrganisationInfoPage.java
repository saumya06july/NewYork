package Vtigerr.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {


	@FindBy(css = ".dvHeaderText") private WebElement Organinfo;
	
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public String organinfo()
	{
		   return Organinfo.getText();
		
		
	}
}
