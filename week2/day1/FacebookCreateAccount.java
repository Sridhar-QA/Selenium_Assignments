package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookCreateAccount {

	public static void main(String[] args) {
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		// Launch the Url
		driver.get("https://en-gb.facebook.com/");
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// click create new account
		driver.findElement(By.linkText("Create new account")).click();
		
		// enter registration details
		driver.findElement(By.name("firstname")).sendKeys("Sridhar");
		driver.findElement(By.name("lastname")).sendKeys("U");
		driver.findElement(By.xpath("//input[contains(@aria-label,\"Mobile number or email address\")]")).sendKeys("strawhats@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label=\"Re-enter email address\"]")).sendKeys("strawhats@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("mugiwara");
		
		// select birth day
		WebElement day = driver.findElement(By.id("day"));
		Select birthDay = new Select(day);
		birthDay.selectByValue("11");
		
		// select birth month
		WebElement month = driver.findElement(By.id("month"));
		Select birthMonth = new Select(month);
		birthMonth.selectByVisibleText("May");
		
		//select birth year
		WebElement year = driver.findElement(By.id("year"));
		Select birthYear = new Select(year);
		birthYear.selectByVisibleText("1999");
		
		// select gender in radio button
		driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input")).click();
		
		// close the browser
		driver.close();
		

	}

}
