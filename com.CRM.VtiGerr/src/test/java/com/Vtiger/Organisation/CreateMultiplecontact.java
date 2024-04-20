package com.Vtiger.Organisation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.VtiGerr.GeneralUtility.Baseclass;
import com.CRM.VtiGerr.GeneralUtility.Excelfileutility;

import Vtigerr.ObjectRepository.ContactPage;
import Vtigerr.ObjectRepository.CreateNewContactPage;
import Vtigerr.ObjectRepository.HomePage;
import Vtigerr.ObjectRepository.OrganisationInfoPage;

public class CreateMultiplecontact extends Baseclass

{

	@Test(dataProvider = "getMultiplecellDate",dataProviderClass = Excelfileutility.class)
	public void multipleContact(String contactname)
	{
		String Actualname = contactname+jutil.getRandom();
		HomePage hp=new HomePage(driver);
		hp.clickcontactLink();
		
		ContactPage cp=new ContactPage(driver);
		cp.clickcontactlookupimg();
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.Createcontact(Actualname);
		OrganisationInfoPage cip=new OrganisationInfoPage(driver);
		String Expected = cip.organinfo();
		
		Assert.assertTrue(Actualname.contains(Expected));
		System.out.println("Pass");
		
	}
}
