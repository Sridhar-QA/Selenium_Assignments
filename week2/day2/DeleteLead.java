package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		// click on leads
		driver.findElement(By.linkText("Leads")).click();
		
		//click find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		// enter phone number and find the leads
		driver.findElement(By.xpath("//a//span[text()='Phone']")).click();
		// 91 044-998877326
		WebElement phoneCountryCode = driver.findElement(By.name("phoneCountryCode"));
		phoneCountryCode.clear();
		phoneCountryCode.sendKeys("91");
		driver.findElement(By.name("phoneAreaCode")).sendKeys("044");
		driver.findElement(By.name("phoneNumber")).sendKeys("998877326");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		// get id of the leads which is about to be deleted
		String deletedLeadId = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).getText();
		Thread.sleep(10000);
		
		// select the first displayed lead and delete the lead
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		// click find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		// enter deleted lead id and find leads
		driver.findElement(By.name("id")).sendKeys(deletedLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		// verify lead deleted successfully
		String noRecordsFound = driver.findElement(By.className("x-paging-info")).getText();
		System.out.println(noRecordsFound);
		if(noRecordsFound.contains("No records to display")) {
			System.out.println("Lead deleted successfully");
		}
		driver.close();
	}

}
