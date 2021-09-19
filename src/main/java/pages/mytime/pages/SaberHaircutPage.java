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

import com.cucumber.helper.ParameterService;
import com.cucumber.helper.UtilClass;

public class SaberHaircutPage extends UtilClass {
	
	private static Logger Log = Logger.getLogger(SaberHaircutPage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	
	/*
	 * 	WebElement For Saber Hair-Cut Page
	 */
	
	@FindBy(xpath = "//h4[.='Haircut']")
	private WebElement headerXPath;
	
	@FindBy(xpath = "//span[.='All services']")
	private WebElement lnkAllServices;
	
	@FindBy(xpath = "(//section[@class='staff-member']//label/span)[3]")
	private WebElement staffMemberXpath;

	@FindBy(xpath = "(//div[contains(@class,'toolbar')]//button[.='Select Time'])[2]")
	private WebElement btnSelectTime;
	
	@FindBy(xpath = "//div[contains(@class,'opentime')]//button")
	private WebElement btnSelectTimeSlot;
	
	//h4[.='Haircut']/parent::section//span[@class='variation-title-content'][contains(text(),'Men')]
	
	@FindBy(xpath = "//li//span[@class='normal-price']")
	private WebElement txtPriceTag;
	
	@FindBy(xpath = "//div[contains(@class,'employee')]//div[contains(@class,'value')]//span")
	private WebElement txtStaffName;

	@FindBy(xpath = "//li[contains(@class,'variation-item')]//span[contains(@class,'variation-name')]")
	private WebElement txtServiceType;	
	
	//button[@aria-label="Book Service Men's Haircut"]
	//span[.="Men's Haircut"]/ancestor::div[contains(@class,'details')]//span[@class="normal-price"]
	
	/* Constructor */

	public SaberHaircutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	    PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.titleContains("Sabre"));
	}
	
	/*
	 *   Methods for This Page
	 */
	
	public boolean verifyPageLoad() {
		wait.until(ExpectedConditions.visibilityOf(headerXPath));
		boolean result = headerXPath.isDisplayed();
		Log.info("Saber Haircut Page Loaded Successfully");
		return result;
	}
	
	public void clickAllBusinessService() {
		Log.info("Clicking All Services ");
		clickElement(driver, lnkAllServices);
	}
	
	public void clickSecondStaffMemberFromFilter() {
		Log.info("Clicking Second-Staff Member From Result");
		wait.until(ExpectedConditions.visibilityOf(staffMemberXpath));
		clickElement(driver, staffMemberXpath);
	}
	
	public void storeDetailsFromResult(String genderType) {
		String serviceXPath = "//h4[.='Haircut']/parent::section//span[@class='variation-title-content'][contains(text(),'"+genderType+"')]";
		String getServiceType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(serviceXPath))).getText().trim();
		ParameterService.setParameter("ServiceType", getServiceType);
		String getStaffName = staffMemberXpath.getText().trim();
		ParameterService.setParameter("StaffName", getStaffName);
		String getMensPriceXpath = "//span[contains(text(),'"+genderType+"')]/ancestor::div[contains(@class,'details')]//span[@class='variation-price variation-span']/span";
		String getPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getMensPriceXpath))).getText().trim();
		ParameterService.setParameter("HaircutPrice", getPrice);
		Log.info("Staff Name :" + getStaffName);
		Log.info("Service Type :" + getServiceType);
		Log.info("Staff Price :" + getPrice);
	}
	
	public void clickAppointmentBook(String genderType) {
		Log.info("Clicking Booking Appointment");
		clickElement(driver, lnkAllServices);
		By getMensBookXpath = By.xpath("//span[contains(text(),'"+genderType+"')]/ancestor::div[contains(@class,'details')]//button");
		clickElementUsingBy(driver, getMensBookXpath);
	}
	
	public void clickBtnSelectTime() {
		Log.info("Clicking Select Time");
		clickElement(driver, btnSelectTime);
	}
	
	public boolean verifyMultipleTimeSlotsForService() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(btnSelectTimeSlot));
		List<WebElement> getSize = driver.findElements(By.xpath("//div[contains(@class,'opentime')]//button"));
		int count = getSize.size();
		if(count >= 2)
			return true;
		else
			return false;
	}
	
	public boolean verifyPriceAndStaffName(String genderType) {
		Log.info("Verify Staff Name And Price Tag");
		wait.until(ExpectedConditions.visibilityOf(txtPriceTag));
		String getCostPrice = txtPriceTag.getText().trim();
		Log.info("Cost Price :" + getCostPrice);
		String getStaffName = txtStaffName.getText().trim();
		Log.info("Staff Name :" + getStaffName);
		String getServiceType = txtServiceType.getText().trim();
		Log.info("Service Type :" + getServiceType);
		
		String storedserviceType = ParameterService.getParameter("ServiceType");
		String storedStaffName = ParameterService.getParameter("StaffName");
		String storedCostPrice = ParameterService.getParameter("HaircutPrice");
		
		if(storedserviceType.contains(getServiceType) && storedStaffName.contains(getStaffName) && storedCostPrice.contains(getCostPrice))
			return true;
		else
			return false;
		/*String getMensPriceXpath = "//span[contains(text(),'"+genderType+"')]/ancestor::div[contains(@class,'details')]//span[@class='variation-price variation-span']/span";
		String getPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getMensPriceXpath))).getText().trim();
		ParameterService.setParameter("StaffPrice", getPrice);
		Log.info("Staff Name :" + getStaffName);
		Log.info("Staff Price :" + getPrice);
		clickElement(driver, staffMemberXpath);*/
	}

}
