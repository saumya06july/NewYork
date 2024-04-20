package Vtigerr.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class loinPage {
	
	@FindBy(name="user_name") private WebElement UsernameEdt;
	@FindBy(name="user_password") private WebElement PasswordEdt;
	
	@FindBy(id="submitButton") private WebElement SubmitBtn;
	
	public loinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	public void login(String username,String password )
	{
		UsernameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}
	
	
	

}
