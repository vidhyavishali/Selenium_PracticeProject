package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CollectionsInSelenium {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//div[@class = 'searchbar-view']//input")).sendKeys("Bags", Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
