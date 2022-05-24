package week3.day2;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CollectionsInSelenium {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	
			
		
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);

		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
	//	WebDriver driver = new ChromeDriver(options);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class = 'searchbar-view']//input")).sendKeys("Bags", Keys.ENTER);

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(3000);
		/*
		 * Locating checkbox itself is not working, so locating the corresponding label
		 */
		driver.findElement(By.xpath("//label[@for='Women']")).click();
		
		
		/*
		 * received stale element reference. implicit wait doesnot work.so using
		 * Thread.sleep()
		 */
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='Women - Utility Bags']")).click();
		Thread.sleep(5000);
		String xpathToItemsDiv = "//div[@id='breadcrumb-container']";
		String text = driver.findElement(By.xpath(
				xpathToItemsDiv + "/following-sibling::div[@class=' filter-container']/div[@class='filter']/div"))
				.getText();
		System.out.println(text);
		List<WebElement> brandOfElements = driver.findElements(By.xpath("//div[@class='brand']"));
		for (WebElement webElement : brandOfElements) {
			System.out.println(webElement.getText());
		}

		driver.quit();
	}

}
