package E2EProject.SDTEST;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jdbConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\91704\\Downloads\\Compressed\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://login.salesforce.com/");
		String host = "localhost";
		String port = "3306";
		// String database = "jdbc:mysql://"+host+":"+port+"/qadbt";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from users WHERE id = 1");

		while (rs.next())
		{
			//
			
			
			driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
			
		}

	}

}
