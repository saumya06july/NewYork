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
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

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

@Listeners(com.CRM.VtiGerr.GeneralUtility.Listenerimplementation.class)

public class CreateOrganisationTest extends Baseclass {
	
@Test(groups = "smoke",retryAnalyzer = com.CRM.VtiGerr.GeneralUtility.RetryAnalyser.class)
	public  void verifyUserOrganisation()throws IOException {
		// TODO Auto-generated method stub


		String Organisation = eutil.getDataFromExcel("Sheet11", 3, 2) + jutil.getRandom();

		
		HomePage hp=new HomePage(driver);
		hp.clickOrgLink();
		Reporter.log("organisation link clicked", true);
		

		

		OrganisationPage org=new OrganisationPage(driver);
		org.ClickorglookUpImg();
		Reporter.log("Lookup linked  clicked", true);
		
		//Assert.fail();
		
		
		CreateNewOrganisationPage cr=new CreateNewOrganisationPage(driver);
		cr.Createorg(Organisation);
		
		OrganisationInfoPage info=new OrganisationInfoPage(driver);
		
		String organisationinformation = info.organinfo();
		
		Assert.assertTrue(organisationinformation.contains(Organisation));
		System.out.println("Pass");
}


		@Test(groups = "smoke")
		public void Regional()
		{
			System.out.println("Regional Regression Testing");
		}
		
		
	

	}



