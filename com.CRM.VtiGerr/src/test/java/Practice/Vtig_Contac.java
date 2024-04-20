/*package Practice;

public class Vtig_Contac {
	package Practice;

	public class contcatOrgcopy1 {
		package Practice;

		import java.io.IOException;
		import java.time.Duration;
		import java.util.Random;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.testng.Assert;
		import org.testng.annotations.Test;

		import com.CRM.VtiGerr.GeneralUtility.Excelfileutility;
		import com.CRM.VtiGerr.GeneralUtility.JavaUtility;
		import com.CRM.VtiGerr.GeneralUtility.PropertiesFileutility;
		import com.CRM.VtiGerr.GeneralUtility.WebdriverUtility;
		import com.CRM.VtiGerr.GeneralUtility.ipathConstant;

		import Vtigerr.ObjectRepository.ContactOrganisationInfoPage;
		import Vtigerr.ObjectRepository.ContactPage;
		import Vtigerr.ObjectRepository.CreateNewContactPage;
		import Vtigerr.ObjectRepository.HomePage;
		import Vtigerr.ObjectRepository.OrganisationPage;
		import Vtigerr.ObjectRepository.loinPage;

		public class CreateContactTest1222 {

			@Test
			public static void verifyContactOrganisation() throws Exception {

				WebDriver driver = null;

				PropertiesFileutility putil = new PropertiesFileutility();
				Excelfileutility eutil = new Excelfileutility();
				JavaUtility jutil = new JavaUtility();
				WebdriverUtility wutil = new WebdriverUtility();

				String un = putil.getProppertyFileData("username");
				String pw = putil.getProppertyFileData("password");
				String URL = putil.getProppertyFileData("url");
				String BROSWER = putil.getProppertyFileData("browser");

				

				String ContactName = eutil.getDataFromExcel("Sheet2", 3, 2) + jutil.getRandom();

				// Runtime Polymorphism or method overriding

				if (BROSWER.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} else if (BROSWER.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else {
					System.out.println("Invalid Broswer");
				}

				// Abstraction

				wutil.maximizepage(driver);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ipathConstant.implicitwaitduration));

				driver.get(URL);
				
				
				loinPage lp=new loinPage(driver);
				lp.login(un, pw);
				HomePage hp=new HomePage(driver);
				hp.clickcontactLink();
			
				ContactPage cp=new ContactPage(driver);
				cp.clickcontactlookupimg();
				
				
				CreateNewContactPage contact=new CreateNewContactPage(driver);
				contact.Createcontact(ContactName);
				
				ContactOrganisationInfoPage conInfo=new ContactOrganisationInfoPage(driver);
				
				String expectContactName = conInfo.contactinfo();
				
				Assert.assertTrue(expectContactName.contains(ContactName));
				System.out.println("Pass");

			
				
				hp.Singout(driver);

				driver.quit();
				

			}

		


	}

}*/
