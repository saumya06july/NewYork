package com.CRM.VtiGerr.GeneralUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.VtiGerr.GeneralUtility.ipathConstant;

import com.CRM.VtiGerr.GeneralUtility.JavaUtility;


public class WebdriverUtility {
	
	
	public void maximizepage(WebDriver driver)
	{
		/**
		 * This method maximize the WebPage
		 * @param driver
		 */
		driver.manage().window().maximize();
		
	}
	public void minimizepage(WebDriver driver)
	{
		/**
		 * This method minimize the webpage
		 * @param driver
		 */
		driver.manage().window().minimize();	
	}
	public void waitThePage(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ipathConstant.implicitwaitduration));
	}
	public void elementToBeclickable(WebDriver driver,WebElement element )
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(ipathConstant.explicitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void visibleTheElement(WebDriver driver,WebElement element )
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(ipathConstant.explicitDuration));
	       wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void alertsIsPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(ipathConstant.explicitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public void titleIsPresent(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(ipathConstant.explicitDuration));
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	public void urlIsPresent(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(ipathConstant.explicitDuration));
		wait.until(ExpectedConditions.urlContains(url));
		
	}
	public void ignoreException(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(ipathConstant.explicitDuration));
		wait.ignoring(NoSuchElementException.class);
		
	}
	
	public void handleDROPDown(WebElement element,int index)
	{
		Select se = new Select(element);
		se.selectByIndex(index);
	}
	public void handleDROPDown(WebElement element,String value)
	{
		Select se = new Select(element);
		se.selectByValue(value);
	}
	public void handleDROPDown(String visibleText,WebElement element)
	{
		Select se = new Select(element);
		se.selectByVisibleText(visibleText);
	}
	public void movetToElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver) ;
		
		act.moveToElement(element).perform();
	}
	public void contextclick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver) ;
		
		act.contextClick(element).perform();
	}
	public void Doubleclick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver) ;
		
		act.doubleClick(element).perform();
	}
	
	public void dragAndDrp(WebDriver driver,WebElement srcelent,WebElement destElememt)
	{
      Actions act = new Actions(driver) ;
		
		act.dragAndDrop(srcelent, destElememt).perform();
	}
	public  void frame(int index,WebDriver driver)
	{
		driver.switchTo().frame(index);
	}
	public  void frame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	public  void frame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public  void parentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public  void defaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public  void Acceptalert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public  void dismissalert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public  void getTextFromAlert(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	public  void passTextintoAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void handleWindow(WebDriver driver,String partialTitle)
	{
		//Capture all the window ids
		Set<String> ids = driver.getWindowHandles();
		//navigate to each window
		for(String winId :ids)
		{
			//navigate to each window and capture the title
			
			String currentTitle=driver.switchTo().window(winId).getTitle();

			//Compare the title with required window title
			if (currentTitle.contains(partialTitle))
			{
				break;
			}
		
		}
	}
	public String screenshot(WebDriver driver,String screnshotname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		JavaUtility jutil=new JavaUtility();
		String currentdate = jutil.getModifiedgetSysdate();
		File dest = new File("./Screenshot/"+currentdate+screnshotname+" .png");
		FileHandler.copy(file, dest);
		return dest.getAbsolutePath();//Extent report
		
	}
	public String screenshotElement(WebElement element,String screnshotname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)element;
		File file = ts.getScreenshotAs(OutputType.FILE);
		JavaUtility jutil=new JavaUtility();
		String currentdate = jutil.getModifiedgetSysdate();
		File dest = new File("./Screenshot/"+currentdate+screnshotname+" .png");
		FileHandler.copy(file, dest);
		return dest.getAbsolutePath();//Extent report
		
	}
	
	
	
	
	


}
