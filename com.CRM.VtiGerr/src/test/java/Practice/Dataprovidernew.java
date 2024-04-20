package Practice;

import org.testng.annotations.DataProvider;

public class Dataprovidernew {
	@DataProvider
	public Object[][] get()
	{
			Object data[][]=new Object[3][3];
			data[0][0]="Samsung";
			data[0][1]=15000;
			data[0][2]=4.2;
			data[1][0]="Nokia";
			data[1][1]=1000;
			data[1][2]=4.4;
			data[2][0]="Realme";
			data[2][1]=25000;
			data[2][2]=4.4;
			
		return data;	
			
			
	}


}
