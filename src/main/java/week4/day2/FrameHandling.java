package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		customInitialBrowserSetup(driver);

		System.out.println("Outside all frames: " + driver.findElement(By.tagName("label")).getText());
		WebElement frame2 = driver.findElement(By.id("frame2"));
		WebDriver frame1 = driver.switchTo().frame("frame1");
		System.out.println("Inside frame1");
		/*
		 * The current driver focus is located to driver. So Frame is not a seperate
		 * webElement, to perform nested search.
		 */
		System.out.println("Accessing with frame1 driver" + frame1.findElement(By.id("topic")).getText());
		System.out.println("Accessing with default driver" + driver.findElement(By.id("topic")).getText());

		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("LearnFrames");

		WebElement frame3 = driver.findElement(By.id("frame3"));
		/*
		 * Wrong way : Using frame3( an webelement object), one cannot locate anything
		 * inside the frame. frame as webelement is used ONLY to switch the driver
		 * control to the target frame.
		 * 
		 * So, below statement gives no such element exception, no matter in whichever
		 * frame the driver control is in.
		 * 
		 * frame3.findElement(By.id("a")).click();
		 */

		/*
		 * correct way : Switch the driver control to the target frame and locate the
		 * element using WEBDRIVER object
		 */
		driver.switchTo().frame(frame3);
		driver.findElement(By.id("a")).click();

		/*
		 * driver.close with respect to frames, closes the tab that has the frame. and
		 * further actions on parent frame gives invalid session exception.
		 * driver.close();
		 */

		/* switching within frames */
		driver.switchTo().parentFrame(); // goes from frame3 to frame1.

		/*
		 * trying to switch between frame1 and frame2. without going to default content
		 * gives stale Element exception.
		 * 
		 * driver.switchTo().frame(frame2)
		 * 
		 * Always go to common parent of both frames(Here default content), before
		 * switching between them.
		 */

		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame2);
		Select animalSelect = new Select(driver.findElement(By.id("animals")));
		animalSelect.selectByIndex(2);

		/* bypassing frames - from anywhere to default frame works. */
		driver.switchTo().defaultContent();
		System.out.println(
				"Switched to default frame from inner frame :" + driver.findElement(By.tagName("label")).getText());

		/*
		 * bypassing frames - from default to inner frame -- the statement gives stale
		 * element reference. though frame3 reference is there, bypassing its parent
		 * frame ( frame1) does not happen.
		 * 
		 * driver.switchTo().frame(frame3); driver.findElement(By.id("a")).click();
		 * 
		 * 
		 */
		driver.quit();
	}

	/** Closes anti virus firewall tab and maximises the active browser window */
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
