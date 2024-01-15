package coverFoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base {
	static protected WebDriver driver;
public void launchCoverFox() throws InterruptedException
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	Reporter.log("launching driver",true);
	driver.get("https://www.coverfox.com/");
	Thread.sleep(1000);
}
public void closeCoverFox() throws InterruptedException
{
	
	Reporter.log("closing driver",true);
		Thread.sleep(1000);
		driver.close();
}


}
