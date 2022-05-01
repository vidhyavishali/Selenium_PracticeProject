package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/checkbox.html");

		// String xPathForDivContent = "//div[@id='contentblock']//";
		String xPathForDivContent = "//section[@class='innerblock']/";

		// Select the languages you know
		driver.findElement(By.xpath(xPathForDivContent + "div[1]/input[1]")).click();
		driver.findElement(By.xpath(xPathForDivContent + "div[1]/input[3]")).click();

		// Confirm selenium is clicked

		boolean checkBoxSelection = driver.findElement(By.xpath(xPathForDivContent + "div[2]/input")).isSelected();
		if (checkBoxSelection)
			System.out.println("Selenium is selected");

		// Deselect the checked.
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//label[text()='DeSelect only checked']/following::input"));
		checkBoxes.forEach(e -> {
			if (e.isSelected()) {
				e.click();
			}
		});

		// click all web elements
		List<WebElement> checkAll = driver.findElements(By.xpath(xPathForDivContent + "div[4]/input"));
		checkAll.forEach(e -> e.click());

		driver.close();

	}

}
