package E2EProject.SDTEST;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.UserPage;
import resources.base;

public class HomePageTest extends base{
	
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	public WebDriver driver;
	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		//driver.get(p.getProperty("url"));
		log.info("driver was initialised");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@Test(dataProvider = "getData")
	public void basepageNavigation(String username,String password, String text) throws IOException, InterruptedException 
	{
		driver.get(p.getProperty("url"));
		log.info("navigated to url");
		LandingPage lp = new LandingPage(driver);
		LoginPage lg = lp.login();
		//LoginPage lg = new LoginPage(driver); not needed
		lg.email().sendKeys(username);
		lg.password().sendKeys(password);
		lg.signInbutton().click();
		log.info(text);
		Thread.sleep(4000);
		UserPage up = new UserPage(driver);
		Assert.assertEquals(up.title().getText(),"All-Access Membership");
		log.info("validated course text");
		/*Assert.assertTrue(up.logo().isDisplayed());
		log.info("validated logo on user page");
		up.searchbox().sendKeys(coursename);
		up.searchbtn().click();*/
		
	}
	
	
	
}
