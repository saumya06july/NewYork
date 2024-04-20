package com.Vtiger.Organisation;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.VtiGerr.GeneralUtility.Baseclass;
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



@Listeners(com.CRM.VtiGerr.GeneralUtility.Listenerimplementation.class)
public class CreateContactTest extends Baseclass {

	@Test(groups = { "smoke","regression"})
	public void verifyContactOrganisation() throws Exception {


		String ContactName = eutil.getDataFromExcel("Sheet2", 3, 2) + jutil.getRandom();

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

	
		
		

	}

}
