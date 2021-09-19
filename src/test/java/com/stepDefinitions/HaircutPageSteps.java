package com.stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mytime.pages.HaircutPage;
import pages.mytime.pages.WebDriverManager;

import org.junit.Assert;

public class HaircutPageSteps {

	public WebDriver driver = getDriver();
	public HaircutPage haircutPage;

	public WebDriver getDriver() {
		return WebDriverManager.driver;
	}
	
	@Then("I Verify Multiple Search Results Displayed for User Searched Service; in Haircut Page")
	public void verifySearchResult() throws Throwable {
		haircutPage = new HaircutPage(driver);
		boolean result = haircutPage.verifyMultipleSearchResultsForService();
		Assert.assertTrue("Search Result is less than 3. Please Check....!!!", result);
	}
	
	@When("I Click On Business Name as {string}; in Haircut Page")
	public void clickBusinessNameService(String businessService) throws Throwable {
		haircutPage = new HaircutPage(driver);
		haircutPage.clickBusinessService(businessService);
	}

}