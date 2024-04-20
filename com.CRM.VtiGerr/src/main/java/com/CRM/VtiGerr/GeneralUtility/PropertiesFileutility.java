package com.CRM.VtiGerr.GeneralUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;





public class PropertiesFileutility {
	
	
	public String getProppertyFileData(String key ) throws IOException
	{
	FileInputStream fis=new FileInputStream(ipathConstant.propertyfilepath);
	Properties p=new Properties();
	p.load(fis);
	String value=p.getProperty(key);
	return value;

}
}