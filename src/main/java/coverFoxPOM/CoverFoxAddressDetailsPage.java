package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxAddressDetailsPage {
	@FindBy(xpath = "(//input[@type='number'])[1]")private WebElement pincodeField;
	@FindBy(xpath="(//input[@type='number'])[2]")private WebElement mobNumField;
	@FindBy(className = "next-btn")private WebElement continueButton;
	@FindBy(className = "error-ui") private WebElement errorMsg;
public	CoverFoxAddressDetailsPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
public void enterPincode(String pin)
{
	pincodeField.sendKeys(pin);
	}

public void enterMobNum(String mobilenum)
{
	mobNumField.sendKeys(mobilenum);
}
public void clickOnContinueButton()
{
	continueButton.click();
	}
public boolean validatePincodeErrorMsg() {
	boolean result=errorMsg.isDisplayed();
	return result;
}
}
	


