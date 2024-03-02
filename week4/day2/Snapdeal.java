package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions act = new Actions(driver);
		WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		act.moveToElement(mensFashion).perform();
		
		driver.findElement(By.xpath("//div[@id='category1Data']//span[text()='Sports Shoes']")).click();
		
		String sportsShoesCount = driver.findElement(By.xpath("//div[text()=\"Men's Sports Fashion\"]/following-sibling::div")).getText();
		System.out.println("Sports Shoes count: "+sportsShoesCount);
		
		// click on training shoes
		driver.findElement(By.xpath("//div[text()=\"Training Shoes\"]/parent::a")).click();
		
		List<WebElement> priceWebElementListBeforeSort = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
		List<Integer> originalPriceListBeforeSort = new ArrayList<Integer>();
		
		for(int i=0; i<priceWebElementListBeforeSort.size(); i++) {
			int price = Integer.parseInt((priceWebElementListBeforeSort.get(i).getText()).replaceAll("[^0-9]",""));
			originalPriceListBeforeSort.add(price);
		}
		
		System.out.println("original price list before sort: "+ originalPriceListBeforeSort);
		
		// filter the price from low to high
		driver.findElement(By.xpath("//i[contains(@class,'sort-arrow')]")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> priceWebElementList = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
		List<Integer> actualSortedPriceList = new ArrayList<Integer>();
		
		for(int i=0; i<priceWebElementList.size(); i++) {
			int price = Integer.parseInt((priceWebElementList.get(i).getText()).replaceAll("[^0-9]",""));
			actualSortedPriceList.add(price);
		}
		
		System.out.println("sorted price list: "+actualSortedPriceList);
		
		WebElement rightSliderButton = driver.findElement(By.xpath("//div[@data-filter-type='slider']//a[contains(@class,'right-handle')]"));
		WebElement leftSliderButton = driver.findElement(By.xpath("//div[@data-filter-type='slider']//a[contains(@class,'left-handle')]"));
		act.scrollToElement(rightSliderButton).perform();
		
		// select price range using slider 562 - 854
		act.dragAndDropBy(rightSliderButton, -19, 0).perform();
		Thread.sleep(2000);
		act.dragAndDropBy(leftSliderButton, 10, 0).perform();
		Thread.sleep(2000);
		
		String priceFromValue = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='fromVal']")).getAttribute("value");
		String priceToValue = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='toVal']")).getAttribute("value");
		
		String filteredPrice = driver.findElement(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill' and contains(.,'Price')]/a")).getText();
		int filteredFromVal = Integer.parseInt(filteredPrice.split("-")[0].replaceAll("[^0-9]", "").trim());
		int filteredToVal = Integer.parseInt(filteredPrice.split("-")[1].replaceAll("[^0-9]", "").trim());
		if((filteredFromVal == Integer.parseInt(priceFromValue)) && (filteredToVal == Integer.parseInt(priceToValue)) ) {
			System.out.println("Price filter is applied for range: "+ "Rs."+ priceFromValue +" - "+ "Rs."+ priceToValue);
		}
		
		driver.findElement(By.xpath("(//div[@data-name='Color_s']//label)[1]")).click();
		String selectedColor = driver.findElement(By.xpath("(//div[@data-name='Color_s']//label)[1]/a[@class='filter-name']")).getText();
		Thread.sleep(3000);
		
		String filteredColor = driver.findElement(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill' and contains(.,'Color')]/a")).getText();
		
		if(filteredColor.trim().equals(selectedColor.trim())) {
			System.out.println("Filter applied for color: "+selectedColor);
		}
		
		WebElement firstProductImage = driver.findElement(By.xpath("(//div[contains(@class,'product-tuple-image')])[1]"));
		act.moveToElement(firstProductImage).perform();
		
		driver.findElement(By.xpath("(//div[contains(@class,'product-tuple-image')])[1]//div[contains(text(),'Quick View')]")).click();
		
		Thread.sleep(1000);
		String price = driver.findElement(By.xpath("//div[contains(@class,'quickProductDescPanel')]//span[@class='payBlkBig']")).getText();
		System.out.println("product price: "+price.trim());
		
		String discount = driver.findElement(By.xpath("//div[contains(@class,'quickProductDescPanel')]//span[contains(@class,'percent-desc')]")).getText();
		System.out.println("discount: "+discount.trim());
		WebElement quickViewModalOfShoe = driver.findElement(By.xpath("//div[contains(@class,'quickViewModal ')]/parent::div"));
		
		File src = quickViewModalOfShoe.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshots/snapdeal/shoe.png");
		FileUtils.copyFile(src, des);
		
		// close quick view modal
		driver.findElement(By.xpath("//div[contains(@class,'sidebarin')]//i[contains(@class,'sd-icon-delete-sign')]")).click();
		
		// close the browser
		driver.close();
		
		
	}

}
