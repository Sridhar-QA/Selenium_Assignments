package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Basic Checkbox 
		driver.findElement(By.xpath("//h5[text()='Basic Checkbox']/following::span[text()='Basic']")).click();
		
		// Notification checkbox - Ajax
		WebElement ajax = driver.findElement(By.xpath("//span[text()='Ajax']/parent::div"));
		ajax.click();
		boolean isAjaxOptionChecked = driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[contains(@class,'ui-state-active')]")).isDisplayed();
		if(isAjaxOptionChecked) {
			System.out.println("Ajax option is checked");
		}
		WebElement checkedNotification = driver.findElement(By.xpath("//span[text()='Checked']"));
		if(checkedNotification.getText() == "Checked") {
			System.out.println("Ajax checkbox is checked");
		}
		System.out.println(checkedNotification.getText());
		
		// Added sleep time to wait for notification to disappear - alternate approach requires hover action and close the notification
		Thread.sleep(10000);
		
		// Languages checkbox - multiple
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("//label[text()='Javascript']")).click();
		
		// Tristate checkbox
		
		// Tristate 1 ---> State = 1
		driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/parent::div//div[contains(@class,'ui-chkbox-box')]")).click();		
		WebElement triState1 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/p"));
		if(triState1.getText().equals("State = 1")) {
			System.out.println("Tristate position is State 1");
		}
		// added wait time for notification to disappear
		Thread.sleep(10000);
		
		// tristate 2 ---> State = 2
		WebElement triState2 = driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/parent::div//div[contains(@class,'ui-chkbox-box')]"));
		triState2.click();
		if(driver.findElement(By.xpath("//div[@class='ui-growl-message']/p")).getText().equals("State = 2")) {
			System.out.println("Tristate position is State 2");
		}
		// added wait time for notification to disappear
		Thread.sleep(10000);
		
		// Tristate 0 ---> State = 0
		WebElement triState0 = driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/parent::div//div[contains(@class,'ui-chkbox-box')]"));
		triState0.click();
		if(driver.findElement(By.xpath("//div[@class='ui-growl-message']/p")).getText().equals("State = 0")) {
			System.out.println("Tristate position is State 0");
		}
		// added wait time for notification to disappear
		Thread.sleep(10000);
		
		// toggle button
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		if(driver.findElement(By.xpath("//span[text()='Checked']")).getText().equals("Checked")) {
			System.out.println("Toggle button is on");
		}
		
		// Disabled checkbox
		boolean isDisabled = driver.findElement(By.xpath("//span[text()='Disabled']/preceding-sibling::div[contains(@class,'ui-state-disabled')]")).isDisplayed();
		if(isDisabled) {
			System.out.println("Checkbox is disabled");
		}
		
		// select multiple checkbox and verify if it is displayed
		driver.findElement(By.xpath("(//h5[text()='Select Multiple']/following::div)[1]")).click();
		driver.findElement(By.xpath("//label[text()='Barcelona']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='Paris']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='London']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//a[@aria-label='Close']")).click();
		if(driver.findElement(By.xpath("//span[@class='ui-selectcheckboxmenu-token-label' and text()='Barcelona']")).isDisplayed()) {
			System.out.println("Barcelona is displayed");
		}
		if (driver.findElement(By.xpath("//span[@class='ui-selectcheckboxmenu-token-label' and text()='London']")).isDisplayed()) {
			System.out.println("London is displayed");
		}
		if(driver.findElement(By.xpath("//span[@class='ui-selectcheckboxmenu-token-label' and text()='Paris']")).isDisplayed()) {
			System.out.println("Paris is displayed");
		}
		
		driver.close();
		
	}

}
