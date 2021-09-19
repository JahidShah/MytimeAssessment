package com.stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mytime.pages.HomePage;
import pages.mytime.pages.WebDriverManager;

import org.junit.Assert;

public class HomePageSteps {

	public WebDriver driver = getDriver();
	public HomePage homePage;

	public WebDriver getDriver() {
		return WebDriverManager.driver;
	}
	
	@Given("I Select Chrome Browser To Launch URL {string} For Test Execution")
	public void i_login_to_application_with_in_browser(String url) throws Throwable {
		driver.get(url);
	}
	
	@Then("I Verify Home Page is Loaded Successfully")
	public void verifyHomePageLoad() throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyPageLoad();
		Assert.assertTrue("Home Page is Not Loaded Properly.", result);
	}
	
	@When("I Enter Service Search as {string}; in Home Page")
	public void setSearchForService(String inputService) throws Throwable {
		homePage = new HomePage(driver);
		homePage.setSearchForService(inputService);
	}
	
	@When("I Click On Service Option as {string} from drop-down; in Home Page")
	public void clickServiceOptionFromDropDown(String inputService) throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickServiceOptionFromDropDown(inputService);
	}
	
	@When("I Enter Location as {string}; in Home Page")
	public void setLocationSearch(String location) throws Throwable {
		homePage = new HomePage(driver);
		homePage.setLocationSearch(location);
	}
	
	@When("I Click On Search Button; in Home Page")
	public void clickSubmitButton() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickBtnSubmit();
	}

}