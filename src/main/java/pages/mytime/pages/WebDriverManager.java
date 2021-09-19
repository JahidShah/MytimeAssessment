package pages.mytime.pages;

import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.core.api.Scenario;


public class WebDriverManager {

	private static Logger Log = Logger.getLogger(WebDriverManager.class);
	public static WebDriver driver;
	public Properties defaultProp;
	
	public WebDriver getDriver(String sValue) throws MalformedURLException {
		driver = startDriver(sValue, 120);
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void closeDriver(Scenario scenario) throws Throwable {
		try {
				if(driver != null) {	
					Log.info("Taking Screenshot..!!");
					takeScreenShot(scenario);
					Log.info("Closing Browser Driver");
					driver.close();
				}	
			}catch (Exception ex) {
				Log.info("Exceptions if anything....!!!!");
				ex.printStackTrace();
			}
	}

	/*
	 *  Set parameters for the webDriver
	*/

	private WebDriver startDriver(String type, int timeout) throws MalformedURLException {
		if(type.equals("chrome")){
			 ChromeOptions options = new ChromeOptions();
			  options.addArguments(
					   "--verbose",
					   "--disable-web-security",
					   "--ignore-certificate-errors",
					   "--allow-running-insecure-content",
					   "--allow-insecure-localhost",
					   "--no-sandbox",
					   "--disable-gpu"
					  );
			  options.setAcceptInsecureCerts(true);
			 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			 driver = new ChromeDriver(options);
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
			 driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public void takeScreenShot(Scenario scenario)throws Exception {
		
		Log.info("Scenario Status   : " + scenario.getStatus());
		
		String status = scenario.getStatus().toString().trim();
	
		if (scenario.isFailed() || status.contains("PASSED")) {
		
			Log.info("Scenario Status");
			try {
		        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		        scenario.embed(screenshot, "image/png");
		      } catch (Exception wde) {
		        System.err.println(wde.getMessage());
		      } 
		}
	  }	

}