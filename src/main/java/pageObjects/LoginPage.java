package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	private By email = By.cssSelector("#email");
	private By password = By.cssSelector("#password");
	
	@FindBy(xpath = "//input[@name='commit']")
	private WebElement loginbutton;
	
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement signInbutton() {
		return loginbutton;
	}

}
