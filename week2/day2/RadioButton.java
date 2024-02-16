package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// select favourite browser
		driver.findElement(By.xpath("//h5[contains(text(),'Your most favorite browser')]/parent::div//label[text()='Firefox']")).click();
		
		// select and unselect radio button
		
		//select bengaluru radio button
		driver.findElement(By.xpath("//h5[contains(text(),'UnSelectable')]/parent::div//label[text()='Bengaluru']")).click();
		System.out.println(driver.findElement(By.xpath("//h5[contains(text(),'UnSelectable')]/parent::div//label[text()='Bengaluru']/preceding-sibling::div/div[contains(@class,'ui-state-active')]")).isSelected());
		boolean selectRadioButton = driver.findElement(By.xpath("//h5[contains(text(),'UnSelectable')]/parent::div//label[text()='Bengaluru']/preceding-sibling::div/div[contains(@class,'ui-state-active')]")).isDisplayed();
		if(selectRadioButton) {
			System.out.println("Radio button is selected");
		}
		
		//unselect bengaluru radio button
		driver.findElement(By.xpath("//h5[contains(text(),'UnSelectable')]/parent::div//label[text()='Bengaluru']")).click();
		boolean unselectRadioButton = driver.findElement(By.xpath("//h5[contains(text(),'UnSelectable')]/parent::div//label[text()='Bengaluru']/preceding-sibling::div/div[contains(@class,'ui-state-default')]")).isDisplayed();
		if(unselectRadioButton) {
			System.out.println("Radio button is unselected");
		}
		
		// default select radio button
		String defaultSelectRadioButton = driver.findElement(By.xpath("//h5[contains(text(),'Find the default select radio button')]/parent::div//div[contains(@class,'ui-state-default') and contains(@class,'ui-state-active')]/parent::div/following-sibling::label")).getText();
		System.out.println("Default select radio button: "+defaultSelectRadioButton);
		
		// check whether age 21-40 is selected. If not selected select the 21-40years
		driver.findElement(By.xpath("//h5[contains(text(),'Select the age group')]/parent::div//div[contains(@class,'ui-state-default') and contains(@class,'ui-state-active')]/parent::div/following-sibling::label")).click();
		
		List<WebElement> selectedAgeGroups = driver.findElements(By.xpath("//h5[contains(text(),'Select the age group')]/parent::div//div[contains(@class,'ui-state-default') and contains(@class,'ui-state-active')]/parent::div/following-sibling::label"));
		if(selectedAgeGroups.size() == 0) {
			driver.findElement(By.xpath("(//h5[contains(text(),'Select the age group')]/parent::div//div[contains(@class,'ui-state-default')]/parent::div/following-sibling::label)[2]")).click();
			System.out.println("Selected the age group 21-40Years");
		}else {
			System.out.println("Age group is already selected");
		}
		
		driver.close();	
	}

}
