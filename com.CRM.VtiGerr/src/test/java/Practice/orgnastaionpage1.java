package Practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.VtiGerr.GeneralUtility.Baseclass;
import com.CRM.VtiGerr.GeneralUtility.Excelfileutility;
import com.CRM.VtiGerr.GeneralUtility.JavaUtility;
import com.CRM.VtiGerr.GeneralUtility.PropertiesFileutility;
import com.CRM.VtiGerr.GeneralUtility.WebdriverUtility;
import com.CRM.VtiGerr.GeneralUtility.ipathConstant;

import Vtigerr.ObjectRepository.CreateNewOrganisationPage;
import Vtigerr.ObjectRepository.HomePage;
import Vtigerr.ObjectRepository.OrganisationInfoPage;
import Vtigerr.ObjectRepository.OrganisationPage;
import Vtigerr.ObjectRepository.loinPage;

public class orgnastaionpage1  extends Baseclass{
	@Test
	public void verifyUserCreateOrganiztion() throws Throwable, IOException {

/*	WebDriver driver = null;

	PropertiesFileutility putil = new PropertiesFileutility();
	Excelfileutility eutil = new Excelfileutility();
	JavaUtility jutil = new JavaUtility();
	WebdriverUtility wutil = new WebdriverUtility();

	String un = putil.getProppertyFileData("username");

	String pw = putil.getProppertyFileData("password");
	String URL = putil.getProppertyFileData("url");
	String BROSWER = putil.getProppertyFileData("browser");*/

	String Organisation = eutil.getDataFromExcel("Sheet11", 3, 2) + jutil.getRandom();

	// Runtime Polymorphism or method overriding

	/*if (BROSWER.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	} else if (BROSWER.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	} else {
		System.out.println("Invalid Broswer");
	}*/

	// Abstraction

	//wutil.maximizepage(driver);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ipathConstant.implicitwaitduration));

	//driver.get(URL);

	
	//loinPage lp=new loinPage(driver);
	//lp.login(un, pw);
	HomePage hp=new HomePage(driver);
	hp.clickOrgLink();
	

	

	OrganisationPage org=new OrganisationPage(driver);
	org.ClickorglookUpImg();
	
	
	CreateNewOrganisationPage cr=new CreateNewOrganisationPage(driver);
	cr.Createorg(Organisation);
	
	OrganisationInfoPage info=new OrganisationInfoPage(driver);
	
	String organisationinformation = info.organinfo();
	
	Assert.assertTrue(organisationinformation.contains(Organisation));
	System.out.println("Pass");

	
	


}
}
