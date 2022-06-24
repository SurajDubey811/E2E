package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import com.google.common.io.Files;

public class base {

	public WebDriver driver;
	public Properties p;

	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {
		p = new Properties();
		String resourcesPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\";
		FileInputStream fis = new FileInputStream(resourcesPath+"\\data.properties");
		p.load(fis);

		String browserName = p.getProperty("browser");
		//String browserName = p.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					resourcesPath+"chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		if (browserName.equalsIgnoreCase("msedge")) {
			System.setProperty("webdriver.edge.driver",
					resourcesPath+"msedgedriver.exe");
			driver = new EdgeDriver();
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					resourcesPath+"geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;

	}
	public String getScreenshotpath(String testMethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png";
		Files.copy(src, new File(destinationFile));
		return destinationFile;
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		
		data[0][0] = "dubeysuraj38@gmail.com";
		data[0][1] = "Suraj@118";
		data[0][2] = "InValid";
		
		
		data[1][0] = "dubeysuryaprakash1@gmail.com";
		data[1][1] = "Suraj@811";
		data[1][2] = "Valid";
		
		
		
		return data;
		
	}

}
