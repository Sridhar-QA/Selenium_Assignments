package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();

		// Launch the application
		driver.get(" https://www.ajio.com/");

		// maximize the browser window
		driver.manage().window().maximize();

		// add implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// enter bags in the search input field and press enter
		driver.findElement(By.className("searchbar-view")).findElement(By.tagName("input")).sendKeys("bags", Keys.ENTER);

		// select Men in Gender
		driver.findElement(By.xpath("//input[@id='Men']/following-sibling::label")).click();

		Thread.sleep(3000);

		// select men fashion bags in category
		driver.findElement(By.xpath("//input[@id='Men - Fashion Bags']/following-sibling::label")).click();

		Thread.sleep(3000);

		// get the total number of items displayed
		String itemsFound = driver.findElement(By.className("filter")).findElement(By.className("length")).getText();
		System.out.println(itemsFound);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		//This will scroll the web page till end.		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// get list of brand names and print it
		List<WebElement> brandNamesList = driver.findElements(By.xpath("//div[@class='brand']/strong"));
		List<String> brandNames = new ArrayList<String>();
		for(WebElement brand: brandNamesList) {
			brandNames.add(brand.getText());
		}
		System.out.println("List of Brand names: "+brandNames);
		System.out.println("Brand names count: "+brandNames.size());

		// get list of bag names and print it
		List<WebElement> bagNamesList = driver.findElements(By.className("nameCls"));
		List<String> bagNames = new ArrayList<String>();
		for(WebElement bagName: bagNamesList) {
			bagNames.add(bagName.getText());
		}
		System.out.println("List of bag names: "+bagNames);
		System.out.println("Bag names count: "+bagNames.size());
		
		driver.close();
	}

}
