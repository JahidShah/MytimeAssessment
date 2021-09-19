package com.cucumber.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {

	private WebDriverWait wait;
	
	public void clickElement(WebDriver driver, WebElement element)
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void clickElementUsingBy(WebDriver driver, By element)
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public String getElementText(WebDriver driver, WebElement element)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public void setText(WebDriver driver, WebElement element, String text)
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}
	
	protected String inputsFromFile(String inputData) {
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("globalinput.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find ");
                return null;
            }
            
            prop.load(input);
            
            String input1 = prop.getProperty(inputData);
            return input1;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
		

}