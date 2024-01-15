package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHealthPlanResultPage {
	@FindBy(xpath = "//div[contains(text(),'matching Health')]")private WebElement resultinString;
	@FindBy(id="plans-list")private List<WebElement> planList;

	public CoverFoxHealthPlanResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public int availablPlanNuberFromText()
	{
		String textresult=resultinString.getText();
		String r[]=textresult.split(" ");
		int numOfResultsinInt=Integer.parseInt(r[0]);
		return numOfResultsinInt;
	}
	public int availablePlanNumberFromBanner()
	{int totalNuberOfPlans=planList.size();
	return totalNuberOfPlans;
	}

}
