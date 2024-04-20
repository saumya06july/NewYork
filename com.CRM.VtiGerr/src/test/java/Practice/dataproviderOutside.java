package Practice;

import org.testng.annotations.Test;

public class dataproviderOutside {
	
	@Test(dataProvider = "get",dataProviderClass = Dataprovidernew.class)

	public void data(String phoneno,int price,double rating)
	{
		System.out.println(phoneno+" "+price+" "+rating);
	}
}
