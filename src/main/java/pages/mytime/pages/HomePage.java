package pages.mytime.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.helper.UtilClass;

public class HomePage extends UtilClass {
	
	private static Logger Log = Logger.getLogger(HomePage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	
	/*
	 * 	WebElement For MyTime - Home Page
	 */
	
	@FindBy(xpath = "//h1[contains(text(),'Book appointments')]")
	private WebElement headerHomePage;
	
	@FindBy(xpath = "(//input[@id='search-query'])[2]")
	WebElement txtSearchField;
	
	@FindBy(xpath = "(//input[@id='search-location'])[2]")
	WebElement txtSearchLocationField;

	@FindBy(xpath = "(//button[contains(@class,'btn-search')])[2]")
	private WebElement btnSubmit;
	
	/* Constructor */

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	    PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.titleContains("MyTime"));
	}
	
	/*
	 *   Methods for This Page
	*/
	
	public boolean verifyPageLoad() {
		wait.until(ExpectedConditions.visibilityOf(headerHomePage));
		boolean result = headerHomePage.isDisplayed();
		Log.info("MyTime Home Page Loaded Successfully");
		return result;
	}
	
	public void setSearchForService(String input) throws InterruptedException {
		Log.info("Enter Your Service Search : " + input);
		setText(driver, txtSearchField, input); 
	}
	
	public void clickServiceOptionFromDropDown(String input) {
		Log.info("Clicking Service Option from drop-down");
		By inputService = By.xpath("//li//a[.='"+input+"']");
		clickElementUsingBy(driver, inputService);
	}
	
	public void setLocationSearch(String inputLocation) throws InterruptedException {
		Log.info("Enter Location Name : " + inputLocation);
		setText(driver, txtSearchLocationField, inputLocation);
		Log.info("Clicking Location Name from drop-down");
		By inputLocationField = By.xpath("//li//a[.='"+inputLocation+"']");
		clickElementUsingBy(driver, inputLocationField);
	}
	
	public void clickBtnSubmit() {
		Log.info("Clicking Submit Button");
		clickElement(driver, btnSubmit);
	}

}
