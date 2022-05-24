package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		// customInitialBrowserSetup(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("This is the first opened window " + driver.getWindowHandle());
		System.out.println("Clicking home..");
		driver.findElement(By.id("home")).click();
		goToNewlyOpenedWindow(driver);
		String windowHandle_toStay = driver.getWindowHandle();
		System.out.println("goes to icons window" + driver.getTitle() + "  " + windowHandle_toStay);
		System.out.println("Clicking on Windows icon..");
		driver.findElement(By.xpath("//h5[text()='Window']")).click();
		System.out.println("same window : Shows work with windows" + driver.getWindowHandle());
		System.out.println("Clicking on Open multiple windows button..");
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		System.out.println(driver.getWindowHandles());
		driver.switchTo()
				.window(new ArrayList<String>(driver.getWindowHandles()).get(driver.getWindowHandles().size() - 2));
		System.out.println("Clicking home in hyperlink window.." + driver.getWindowHandle());
		driver.findElement(By.linkText("")).click();
		System.out.println("Closing the current home window" + driver.getTitle() + " " + driver.getWindowHandle());
		driver.close();

		/* Switching to the window, that we would like to stay */
		driver.switchTo().window(windowHandle_toStay);
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		System.out.println("After waiting for 5 seconds, moved to " + driver.getCurrentUrl());

		System.out.println("Closing all windows except default and 2nd opened window");
		/* switching using window handle name */
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		for (int i = 1; i < windowHandles.size(); i++) {
			String win = windowHandles.get(i);
			if (!win.equals(windowHandle_toStay)) {
				driver.switchTo().window(win);
				driver.close();
			}
		}
		goToDefaultWindow(driver);
		System.out.println("This is the first opened window " + driver.getWindowHandle());
		Thread.sleep(6000);
		System.out.println("Quitting should close all windows opened for the session");
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
