package com.CRM.VtiGerr.Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotclassPractice {
	WebDriver driver;
	public void accessBrowser()
	{
driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.google.co.in/");
	
		
	}
	
	public void openDevTool() throws AWTException
	{
		Actions action=new Actions(driver);
		
		action.contextClick().perform();
		
		Robot r=new Robot();
		for(int i=0;i<10;i++)
		{
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
