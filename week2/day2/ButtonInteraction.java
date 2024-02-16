package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonInteraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// button click to navigate to dashboard page
		driver.findElement(By.xpath("//h5[text()='Click and Confirm title.']/following-sibling::button")).click();
		if(driver.getTitle().equals("Dashboard")) {
			System.out.println("Title of the page is Dashboard");
		}
		driver.navigate().back();
		
		// button disabled
		boolean isButtonEnabled = driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/following-sibling::button")).isEnabled();
		if(!isButtonEnabled) {
			System.out.println("Button is disabled");
		}
		
		// button position
		Point location = driver.findElement(By.xpath("//h5[contains(text(),'Find the position of the Submit button')]/following-sibling::button")).getLocation();
		System.out.println("Button position X: "+ location.getX());
		System.out.println("Button position Y: "+ location.getY());
		
		// colour of save button
		String saveButtonColor = driver.findElement(By.xpath("//h5[contains(text(),'Find the Save button color')]/following-sibling::button")).getCssValue("background-color");
		System.out.println("save button color: "+saveButtonColor);
		
		// height and width of the button
		Dimension size = driver.findElement(By.xpath("//h5[contains(text(),'Find the height and width of this button')]/following-sibling::button")).getSize();
		System.out.println("Height of button: "+size.getHeight());
		System.out.println("Width of button: "+size.getWidth());
		
		driver.close();
	}

}
