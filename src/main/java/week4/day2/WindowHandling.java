package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
	//	customInitialBrowserSetup(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//div[@id ='left-content-column']//li[4]/a")).click();

		/*
		 * 1. clicking on from contact widget icon 2. move to the newly opened window
		 * 3.locate the first element from the table 4. switch to default window
		 */
		driver.findElement(By.xpath("//table[@class='twoColumnForm']//img[1]")).click();
		goToNewlyOpenedWindow(driver);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table'][1]//a")).click();
		/* Move the control back to default window */
		goToDefaultWindow(driver);

		/*
		 * clicking on to contact widget icon - using following sibling, as the first
		 * method wit img[2] doesnt fetch the target
		 */
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		goToNewlyOpenedWindow(driver);
		driver.findElement(By.xpath("//div[@class='x-grid3-row   '][2]//a")).click();
		goToDefaultWindow(driver);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		/*
		 * switch to the alert and accept them. One does not need to switch windows to
		 * default after processing the alert. The control comes directly to the last
		 * opened window
		 */
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Title of the page :" + driver.getTitle());
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
