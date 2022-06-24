package E2EProject.SDTEST;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class NavigateBar extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		log.info("driver was initialised");
		driver.get(p.getProperty("url"));
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void navigationbar() throws IOException {
		
		
		log.info("navigated to url");
		LandingPage lp = new LandingPage(driver);
		Assert.assertFalse(lp.navigationBar().isDisplayed());
		log.info("validated navigation bar on landing page");
		
		
	}

}
