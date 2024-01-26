package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException {
		//Reporter.log("reding data from excel",true);
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel1.xlsx");
		  org.apache.poi.ss.usermodel.Sheet mysheet = WorkbookFactory.create(myfile).getSheet("CoverFoxData");
		  String data = mysheet.getRow(row).getCell(cell).getStringCellValue();
		  return data;
		
	}
public static void takeScreenShot(WebDriver driver,String TCID) throws IOException
{
	Reporter.log("Taking Screenshot",true);
	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("D:\\Sonali\\screenshot\\coverfoxscreenshot"+TCID+"_"+timeStamp+".png");
	Reporter.log("saved screenshot at"+dest,true);
	FileHandler.copy(src, dest);
	
}

}

