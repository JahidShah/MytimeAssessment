package pages.mytime.pages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.helper.UtilClass;

public class HaircutPage extends UtilClass {
	
	private static Logger Log = Logger.getLogger(HaircutPage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	
	/*
	 * 	WebElement For Hair-Cut Page
	 */
	
	@FindBy(xpath = "//ul[@id='results']")
	private WebElement listSearchResult;
	
	/* Constructor */

	public HaircutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	    PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.titleContains("Haircut"));
	}
	
	/*
	 *   Methods for This Page
	 */
	
	public boolean verifyMultipleSearchResultsForService() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(listSearchResult));
		List<WebElement> getSize = driver.findElements(By.xpath("//ul[@id='results']/li"));
		int count = getSize.size();
		if(count >= 3)
			return true;
		else
			return false;
	}
	
	public void clickBusinessService(String input) {
		Log.info("Clicking Business Service : " + input);
		By businessXPath = By.xpath("//h2[@class='business-name']//a[.='"+input+"']");
		clickElementUsingBy(driver, businessXPath);
	}

}
