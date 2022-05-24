package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		// customInitialBrowserSetup(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select ddByIndex = new Select(driver.findElement(By.id("dropdown1")));
		Select ddByText = new Select(driver.findElement(By.name("dropdown2")));
		Select ddByValue = new Select(driver.findElement(By.id("dropdown3")));
		Select ddNumOfOpt = new Select(driver.findElement(By.className("dropdown")));
		WebElement ddSendKeys = driver.findElement(By.xpath("//div[@class='example'][5]/select"));
		Select ddmultiples = new Select(driver.findElement(By.xpath("//div[@class='example'][6]/select")));

		ddByIndex.selectByIndex(3);// UFT
		System.out.println(ddByIndex.getFirstSelectedOption().getText());
		ddByIndex.selectByIndex(1);// Selenium
		System.out.println(ddByIndex.getFirstSelectedOption().getText());

		ddByText.selectByVisibleText("Appium"); // appium
		System.out.println(ddByText.getFirstSelectedOption().getText());

		ddByValue.selectByValue("4"); // LoadRunner
		System.out.println(ddByValue.getFirstSelectedOption().getText());

		System.out.println("Number of options :" + ddNumOfOpt.getOptions().size());

		ddSendKeys.sendKeys("Selenium");

		ddmultiples.deselectAll();
		ddmultiples.selectByIndex(4);
		ddmultiples.selectByValue("1");
		ddmultiples.selectByVisibleText("UFT/QTP");

		System.out.println("Selected Values are");
		ddmultiples.getAllSelectedOptions().forEach(e -> System.out.println(e.getText()));

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

}
