package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	
	@FindBy(css = ".navigation.clearfix")
	private WebElement navigationBar;
	
	@FindBy(css = ".logo")
	private WebElement logo;
	
	public LoginPage login() {
		
		driver.findElement(signin).click();
		LoginPage lg = new LoginPage(driver);
		return lg;
		
	}
	
	public WebElement navigationBar() {
		return navigationBar;
	}
	
	public WebElement logo() {
		return logo;
	}

}
