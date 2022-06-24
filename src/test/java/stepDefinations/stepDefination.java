package stepDefinations;


import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.UserPage;
import resources.base;


@RunWith(Cucumber.class)
public class stepDefination extends base {
	LandingPage lp;
	LoginPage lg;

    @Given("^I am on the chrome browser$")
    public void i_am_on_the_chrome_browser() throws Throwable {
    	driver = initializeDriver();
    }

    @When("^I navigated to the \"([^\"]*)\" link$")
    public void i_navigated_to_the_something_link(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @Then("^I should be successfully logged in to the application$")
    public void i_should_be_successfully_logged_in_to_the_application() throws Throwable {
    	UserPage up = new UserPage(driver);
		Assert.assertEquals(up.title().getText(),"All-Access Membership");
    }

    @And("^I click on the Login button on the landing page$")
    public void i_click_on_the_login_button_on_the_landing_page() throws Throwable {
    	 lp = new LandingPage(driver);
    	 lg = lp.login();
    	
    }

    @And("^I enter (.+) and (.+) and try to login$")
    public void i_enter_something_and_something_and_try_to_login(String username, String password) throws Throwable {
    	
    	lg.email().sendKeys(username);
		lg.password().sendKeys(password);
		lg.signInbutton().click();
    }

}