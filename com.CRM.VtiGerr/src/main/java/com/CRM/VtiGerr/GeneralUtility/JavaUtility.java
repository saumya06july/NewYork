package com.CRM.VtiGerr.GeneralUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	

	public int getRandom() {
		
		Random r=new Random();
		int random = r.nextInt(1000);
	
		return random;
	}
	
	
	public String SysdatAndTime()
	{
		Date d= new Date();
		
		return d.toString() ;
	}
	
	public String getModifiedgetSysdate()
	{
		Date d=new Date();
		String date[]=d.toString().split(" ");
		String date1=date[2];
		String month=date[1];
		String time=date[3].replaceAll(":" ,"-");
		String year=date[5];
	String currentdate= date1+" "+time+" "+month+" "+year;
	return currentdate;
	
		
	}


}
