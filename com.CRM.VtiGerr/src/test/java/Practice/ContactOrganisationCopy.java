package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.CRM.VtiGerr.GeneralUtility.Excelfileutility;
import com.CRM.VtiGerr.GeneralUtility.JavaUtility;
import com.CRM.VtiGerr.GeneralUtility.PropertiesFileutility;
import com.CRM.VtiGerr.GeneralUtility.ipathConstant;

public class ContactOrganisationCopy {
	public static void main(String[] args) throws Exception {
		
		
		
		WebDriver driver=null;
		
		PropertiesFileutility putil=new PropertiesFileutility();
		Excelfileutility eutil = new Excelfileutility();
		JavaUtility jutil = new JavaUtility();

		String un = putil.getProppertyFileData("username");
		String pw = putil.getProppertyFileData("password");
		String URL = putil.getProppertyFileData("url");
		String BROSWER = putil.getProppertyFileData("browser");
		
	
		String ContactName = eutil.getDataFromExcel("Sheet2", 3, 2) + jutil.getRandom();
		
		//Runtime Polymorphism or method overriding
		
	if(BROSWER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROSWER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Broswer");
		}
		
		//Abstraction 
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ipathConstant.implicitwaitduration));
		
		
		driver.get(URL);  
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(ContactName);
		driver.findElement(By.name("button")).click();
		String expectContactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(expectContactName.contains(ContactName))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}

}
