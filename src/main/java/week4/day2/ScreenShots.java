package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShots {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		// customInitialBrowserSetup(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 pro", Keys.ENTER);
		WebElement resultElem = driver.findElement(By.xpath(
				"//div[@class='a-section a-spacing-none s-padding-right-small s-title-instructions-style']//h2//span"));
		String firstResultText = resultElem.getText();
		String price = driver.findElement(By.xpath("//div[@class='a-section']//span[@class='a-price-whole']"))
				.getText();
		String ratings = driver.findElement(By.xpath("//div[@class='a-row a-size-small']//span[2]"))
				.getAttribute("aria-label");
		System.out.println("The first suggested is:" + firstResultText);
		System.out.println("Price:" + price);
		System.out.println("Ratings:" + ratings);
		resultElem.click();
		goToNewlyOpenedWindow(driver);
		File ss = driver.getScreenshotAs(OutputType.FILE);
		File op = new File("./snaps/mobileDetails.png");
		FileUtils.copyFile(ss, op);
		driver.findElement(By.id("add-to-cart-button")).click();
		String cartPrice = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		// String cartPrice =
		// driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("CartPrice is:" + cartPrice);
		if (cartPrice.trim().equals(price.trim()))
			System.out.println("Price validated");
		Thread.sleep(5000);
		driver.quit();

	}

	/**
	 * This method closes the firewall secutiry window that is opened as first tab
	 * when automating using chrome
	 */
	private static void customInitialBrowserSetup(ChromeDriver driver) {
		driver.manage().window().maximize();
		goToDefaultWindow(driver);
		driver.close();
		goToDefaultWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	/**
	 * Fetches all the windows and moves the control to the default opened window.
	 * i.e., the window thats been opened first by the driver
	 */
	private static void goToDefaultWindow(ChromeDriver driver) {
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(0));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	/**
	 * Fetches the windows opened by the driver and moves the control to the Window
	 * that has been opened recently
	 */
	private static void goToNewlyOpenedWindow(ChromeDriver driver) {
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
