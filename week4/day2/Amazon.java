package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Launch the application 
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		
		Thread.sleep(5000);
		String firstProductPrice = driver.findElement(By.xpath("(//div[contains(@class,'s-card-container')])[1]//span[@class='a-price']")).getText();
		System.out.println("first product price with symbol: "+firstProductPrice);
		int formattedProductPrice = Integer.parseInt(firstProductPrice.replaceAll("[^0-9]", ""));
		System.out.println("Price of first product: "+ formattedProductPrice);
		
		// click on the star rating to get the rating text
		driver.findElement(By.xpath("(//div[contains(@class,'s-card-container')])[1]//span[@class='a-icon-alt']//ancestor::a[@role='button']")).click();
		
		// alternate locator to click on star
		// driver.findElement(By.xpath("(//div[contains(@class,'s-card-container')])[1]//i[contains(@class,'a-icon-star-small')]")).click();
		
		String customerRatingForFirstProduct = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText();
		System.out.println("Customer rating of first product: "+customerRatingForFirstProduct);
		
		String numberOfCustomerReview = driver.findElement(By.xpath("(//div[contains(@class,'s-card-container')])[1]//span[contains(@class, 's-underline-text')]")).getText();
		System.out.println("Number of customer review: "+numberOfCustomerReview);
		
		driver.findElement(By.xpath("(//div[contains(@class,'s-card-container')])[1]//div[@data-cy='title-recipe']/h2/a")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windows);
		WebDriver window = driver.switchTo().window(windowsList.get(1));
		
		// Take screenshot of the product
		WebElement productImage = window.findElement(By.id("dp-container"));
		File src = productImage.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshots/amazon/productImage.png");
		FileUtils.copyFile(src, des);
		
		window.findElement(By.id("add-to-cart-button")).click();
		
		String productSubTotal = window.findElement(By.xpath("//span[contains(@class,'sw-subtotal-amount')]//span[@class='a-price-whole']")).getText();
		if((Integer.parseInt(productSubTotal.replaceAll("[^0-9]", "")) == formattedProductPrice)) {
			System.out.println("Product price matches. Price of the product is: "+formattedProductPrice );
		}
		
		window.close();
		driver.switchTo().window(windowsList.get(0));
		driver.close();
	}

}
