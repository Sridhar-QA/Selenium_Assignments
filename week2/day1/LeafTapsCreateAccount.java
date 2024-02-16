package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafTapsCreateAccount {

	public static void main(String[] args) {
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("SeleniumTester");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		
		// select industry
		WebElement industry = driver.findElement(By.name("industryEnumId"));
		Select industryOption = new Select(industry);
		industryOption.selectByVisibleText("Computer Software");
		
		// select ownership
		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select ownershipOption = new Select(ownership);
		ownershipOption.selectByVisibleText("S-Corporation");
		
		// select source
		WebElement source = driver.findElement(By.name("dataSourceId"));
		Select sourceOption = new Select(source);
		sourceOption.selectByValue("LEAD_EMPLOYEE");
		
		// select marketing
		WebElement marketing = driver.findElement(By.id("marketingCampaignId"));
		Select marketingOption = new Select(marketing);
		marketingOption.selectByIndex(5);
		
		// select state/province
		WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select stateOption = new Select(state);
		stateOption.selectByValue("TX");
		
		// create account
		driver.findElement(By.className("smallSubmit")).click();
		
		// get account name
		WebElement accountName = driver.findElement(By.xpath("//span[contains(text(), 'SeleniumTester')]"));
		System.out.println(accountName.getText());
		
		// verify account created
		if(accountName.getText().contains("SeleniumTester")) {
			System.out.println("Account created successfully");
		}else {
			System.out.println("Account not created");
		}
		
	}

}
