package Practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TowriteTheDataIntoPropertuesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties p=new Properties();
		p.setProperty("browser", "chrome");
		p.setProperty("url","http://localhost:8888");
		p.setProperty("username","admin");
		p.setProperty("password","password");
		
		FileOutputStream fos=new FileOutputStream("src/test/resources/CommonData.properties");
		p.store(fos, "Propertiesfiledata");
		System.out.println("ADDED");

	}

}
