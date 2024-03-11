package week5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {
	
	public RemoteWebDriver driver;
	
	public String fileName;
	
	@Parameters({"browser", "url", "userName", "password"})
	@BeforeMethod
	public void preCondition(String browser, String url, String userName, String password) {
		if(browser.equalsIgnoreCase("Edge")) {			
			driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@DataProvider(name="readExcelData")
	public String[][] getData() throws IOException {
		
		return ReadDataFromExcel.getExcelData(fileName);
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}
