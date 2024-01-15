package coverFoxTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxUtility.Utility;
@Listeners(listener.ListenerCoverFox.class)
public class CF_TC556_Validaate_Pincode_Error_Msg extends Base {
	coverFoxPOM.CoverFoxHomePage home;
	coverFoxPOM.CoverFoxHealthPlanPage healthPlan;
	coverFoxPOM.CoverFoxAddressDetailsPage addressDetails;
	coverFoxPOM.CoverFoxMemberDetailsPage memberDetails;
	coverFoxPOM.CoverFoxHealthPlanResultPage result;
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
	launchCoverFox();
	home=new coverFoxPOM.CoverFoxHomePage(driver);
	healthPlan=new coverFoxPOM.CoverFoxHealthPlanPage(driver);
	addressDetails=new coverFoxPOM.CoverFoxAddressDetailsPage(driver);
	memberDetails=new coverFoxPOM.CoverFoxMemberDetailsPage(driver);	
	result=new coverFoxPOM.CoverFoxHealthPlanResultPage(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
	
	@BeforeMethod
	public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		//Reporter.log("clicking gender button",true);
		  home.clickOnMaleButton();
		  Thread.sleep(1000);
		  
		  //Reporter.log("clicking on next button",true);
		  healthPlan.ClickOnNextButton();
		  Thread.sleep(1000);
		  
		  //Reporter.log("handling dropdown button",true);
		  memberDetails.handleAgeDropDown(Utility.readDataFromExcel(1,0));
		 
		  //Reporter.log("clicking on next button",true);
		  memberDetails.clickOnNextButton();
		  Thread.sleep(1000);
		  
		  //Reporter.log("entering pin",true);
		  addressDetails.enterPincode(Utility.readDataFromExcel(1, 1));
		  //Reporter.log("entering mobile",true);
		  addressDetails.enterMobNum(Utility.readDataFromExcel(1, 2));
		  //Reporter.log("click on continue",true);
		  addressDetails.clickOnContinueButton();
		  Thread.sleep(1000);
	}
  @Test
  public void Validaate_Pincode_Error_Msg() {
	  Reporter.log("_Validaate_Pincode_Error_Msg",true);
	 boolean result= addressDetails.validatePincodeErrorMsg();
			 Assert.assertTrue(result,"Pincode error msg not displayed,TC fail");
			 Reporter.log("TC is passed",true);
  }
  @AfterMethod
  public void closeBrowser() throws InterruptedException
  {
  	  Reporter.log("closing browser",true);
  	  Thread.sleep(5000);
  	  driver.close();
  }
}
