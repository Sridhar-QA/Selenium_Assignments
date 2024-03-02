package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Launch the application 
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Login to application and click crmsfa
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		// click from contact widget in merge contacts page
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("//span[text()='From Contact']/ancestor::tr//a")).click();
		
		// get the windows opened and navigate to 1st window (from contact window)
		Set<String> firstWindowHandles = driver.getWindowHandles();
		List<String> firstWindowHandleList = new ArrayList<String>(firstWindowHandles);
		WebDriver firstWindow = driver.switchTo().window(firstWindowHandleList.get(1));
		
		// select first element from the list of contacts
		firstWindow.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//tr[1]//td[1]//a")).click();
		
		// switch page to home window
		driver.switchTo().window(firstWindowHandleList.get(0));
		
		// click to contact widget
		driver.findElement(By.xpath("//span[text()='To Contact']/ancestor::tr//a")).click();
		
		// get list of windows and switch to second window (to contact window)
		Set<String> secondWindowHandles = driver.getWindowHandles();
		List<String> secondWindowHandleList = new ArrayList<String>(secondWindowHandles);
		WebDriver secondWindow = driver.switchTo().window(secondWindowHandleList.get(1));
		
		// get second contact from the list of contacts
		secondWindow.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//tr[1]//td[1]//a")).click();
		
		// switch to home window
		driver.switchTo().window(secondWindowHandleList.get(0));
		
		// click merge
		driver.findElement(By.linkText("Merge")).click();
		
		// handle alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// add sleep since get title from web page is inconsistent
		Thread.sleep(6000);
		
		// get page title - This is consistent when verified before clicking merge and handling alert. Becomes incosistent if it is verified after alert handling.
		if(driver.getTitle().contains("Merge Contact")) {
			System.out.println("Verified Merge contact page title");
		}else {
			System.out.println("Unable to get the page title. Inconsistent behaviour from application");
		}
		
		driver.close();
	}
}
