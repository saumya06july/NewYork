package com.CRM.VtiGerr.GeneralUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Vtigerr.ObjectRepository.HomePage;
import Vtigerr.ObjectRepository.loinPage;

public class Baseclass {
	public static WebDriver sdriver;//listener
	 public WebDriver driver;
	
	public PropertiesFileutility putil=new PropertiesFileutility();
	public WebdriverUtility  wutil=new WebdriverUtility();
	public Excelfileutility eutil=new Excelfileutility();
	public JavaUtility jutil = new JavaUtility();
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void comfog_Bs()
	{
		System.out.println("Db connection");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"smoke","regression"})
	public void config_Bc(/*String Browser*/) throws Exception
	{
		//String Browser = putil.getProppertyFileData("browser");
		String Browser=System.getProperty("browser");
		
		if(Browser.equalsIgnoreCase("chrome")){
			
			driver=new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{

			driver=new FirefoxDriver();
		}
		else
		{
			//driver=new EdgeDriver();
			
	}
	}
	@BeforeMethod(groups = {"smoke","regression"})
	public void config_Bm() throws Throwable
	{
		String un = putil.getProppertyFileData("username");

		String pw = putil.getProppertyFileData("password");
		String URL = putil.getProppertyFileData("url");
		sdriver=driver;
		wutil.maximizepage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ipathConstant.implicitwaitduration));

		driver.get(URL);
		loinPage lp=new loinPage(driver);
		lp.login(un, pw);
	}
		
	@AfterMethod(groups = {"smoke","regression"})
	public void Config_Am()
	{
		HomePage hp=new HomePage(driver);
		hp.Singout(driver);
	}
	@AfterClass(groups = {"smoke","regression"})
	public void config_BC() {
		driver.close();
	}
	@AfterSuite (groups = {"smoke","regression"})
	public void config_AS() {
		System.out.println("DB connection closed");
	}

		
	

}
