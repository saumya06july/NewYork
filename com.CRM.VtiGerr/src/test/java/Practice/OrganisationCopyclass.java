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

import com.CRM.VtiGerr.GeneralUtility.PropertiesFileutility;

public class OrganisationCopyclass {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=null;
		
		PropertiesFileutility putil=new PropertiesFileutility();
		
	
		String un = putil.getProppertyFileData("username");
		String pw = putil.getProppertyFileData("password");
		String URL = putil.getProppertyFileData("url");
		String BROSWER = putil.getProppertyFileData("browser");
		
		Random r=new Random();
		int random=r.nextInt(1000);
		String Organisation="QSpTechnology"+random;
		
		//String Organisationname=util.getDataFromExcel("Data", 0, 0)+jutil.getRandom();
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		
		driver.get(URL);  
		
         driver.findElement(By.name("user_name")).sendKeys(un);
         driver.findElement(By.name("user_password")).sendKeys(pw);
        driver.findElement(By.id("submitButton")).click();
		
	
		
       driver.findElement(By.linkText("Organizations")).click();
	
         
driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
		
		
		
        driver.findElement(By.name("accountname")).sendKeys(Organisation);
        driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\" and @value=\"  Save  \"]  ")).click();
		
		
		
         String organisationinfo = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		
		
         if(organisationinfo.contains(Organisation))
         {
        	 System.out.println("pass");
        }
         else
         {
        	 System.out.println("fail");
         }
        	 
       
         WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
        Actions action =new Actions(driver);
         action.moveToElement(ele).perform();
        driver.findElement(By.linkText("Sign Out")).click();
         
         
       
        
         driver.quit();

	}

}
