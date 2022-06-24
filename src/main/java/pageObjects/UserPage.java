package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	
	public WebDriver driver;
	public UserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	private By title = By.cssSelector("div[title='All-Access Membership']");
	
	
	@FindBy(css = ".logo")
	private WebElement logo;
	
	@FindBy(css = "#search-courses")
	private WebElement searchbox;
	
	@FindBy(css = "#search-course-button")
	WebElement searchbtn;
	
	public WebElement title() {
		return driver.findElement(title);
	}
	
	public WebElement logo() {
		return logo;
	}
	public WebElement searchbox() {
		return searchbox;
	}
	public WebElement searchbtn() {
		return searchbtn;
	}
	
}
