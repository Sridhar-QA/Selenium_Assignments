package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		// Fill create lead form/details
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Testleaf Academy");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Sridhar");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("U");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Sridhar");
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Software Testing");
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("This is create lead form");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("onigashima@testleaf.com");
		WebElement stateProvince = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
		Select stateProvinceOption = new Select(stateProvince);
		stateProvinceOption.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(3000);
		
		// Edit lead
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("Clear the description field and entered important description");
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("Resulting page title: "+title);
		
		driver.close();
	}

}
