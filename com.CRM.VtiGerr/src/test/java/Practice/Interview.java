package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in");
		String data = driver.getWindowHandle();
		
		boolean flag=false;
		
		Set<String> data1 = driver.getWindowHandles();
		
		for(String d:data1)
		{
			if(d.equals(data))
			{
				flag=true;
				break;
			}
		}
		
		
if(flag==true)
{
	System.out.println("Window found");
}
	}

}
