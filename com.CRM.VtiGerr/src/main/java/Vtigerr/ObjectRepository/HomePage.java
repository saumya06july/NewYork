package Vtigerr.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.VtiGerr.GeneralUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility {
	@FindBy(linkText = "Organizations") private WebElement orglink;
	@FindBy(linkText = "Contacts") private WebElement contactLink;
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement Adminstratorimg;
	@FindBy(linkText = "Sign Out") private WebElement SignoutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOrgLink()
	{
		orglink.click();
	}
	public void clickcontactLink()
	{
		contactLink.click();
	}
	public void Singout(WebDriver driver)
	{
		
		
		movetToElement(driver,Adminstratorimg);
		SignoutLink.click();
	}
	
	

}
