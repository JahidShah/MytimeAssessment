package com.stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mytime.pages.SaberHaircutPage;
import pages.mytime.pages.WebDriverManager;

import org.junit.Assert;

public class SaberHaircutPageSteps {

	public WebDriver driver = getDriver();
	public SaberHaircutPage saberHaircutPage;

	public WebDriver getDriver() {
		return WebDriverManager.driver;
	}
	
	@Then("I Verify Saber Haircut Page loaded Successfully")
	public void verifyPageLoad() throws Throwable {
		saberHaircutPage = new SaberHaircutPage(driver);
		boolean result = saberHaircutPage.verifyPageLoad();
		Assert.assertTrue("Page is not loaded. Please Check....!!!", result);
	}
	
	@When("I Click On All Business Services; in Saber Haircut Page")
	public void clickAllBusinessService() throws Throwable {
		saberHaircutPage = new SaberHaircutPage(driver);
		saberHaircutPage.clickAllBusinessService();
	}
	
	@When("I Click On Second Staff in Filter From Staff Member Option; in Saber Haircut Page")
	public void clickStaffMember() throws Throwable {
		saberHaircutPage = new SaberHaircutPage(driver);
		saberHaircutPage.clickSecondStaffMemberFromFilter();
	}
	
	@When("I Store Results of {string} Gender Haircut Details; in Saber Haircut Page")
	public void storeDetailsFromResult(String genderType) throws Throwable {
		saberHaircutPage = new SaberHaircutPage(driver);
		saberHaircutPage.storeDetailsFromResult(genderType);
	}
	
	@When("I Click On {string} Gender Type Book Button; in Saber Haircut Page")
	public void clickAppointmentBook(String genderType) throws Throwable {
		saberHaircutPage = new SaberHaircutPage(driver);
		saberHaircutPage.clickAppointmentBook(genderType);
	}
	
	@When("I Click On Select Time Button; in Saber Haircut Page")
	public void clickAppointmentBook() throws Throwable {
		saberHaircutPage = new SaberHaircutPage(driver);
		saberHaircutPage.clickBtnSelectTime();
	}
	
	@Then("I Verify Atleast Two Time Slots Availale for Haircut Booking; in Saber Haircut Page")
	public void verifyMultipleTimeSlotsForService() throws Throwable {
		saberHaircutPage = new SaberHaircutPage(driver);
		boolean result = saberHaircutPage.verifyMultipleTimeSlotsForService();
		Assert.assertTrue("Multiple Time Slots For Service is having problem. Please Check....!!!", result);
	}
	
	@Then("I Compare Details Stored for {string} is same as Details Displayed in Saber Haircut Page")
	public void verifyMultipleTimeSlotsForService(String genderType) throws Throwable {
		saberHaircutPage = new SaberHaircutPage(driver);
		boolean result = saberHaircutPage.verifyPriceAndStaffName(genderType);
		Assert.assertTrue("Problem in Details During Comparing. Please Check....!!!", result);
	}
}