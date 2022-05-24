package week4.day1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table");
		driver.manage().window().maximize();
		/** 1. Print number of Rows and Columns in the table */
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
		System.out.println("Number of rows :" + rows.size());
		List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));
		System.out.println("Number of columns:" + columns.size());
		/** 2. Print the percentage values of given Libraries */
		List<WebElement> library = driver.findElements(By.xpath("//div[@class='render']//tbody/tr/td[1]"));
		List<WebElement> jquery = driver.findElements(By.xpath("//div[@class='render']//tbody/tr/td[2]"));
		List<WebElement> bootstrap = driver.findElements(By.xpath("//div[@class='render']//tbody/tr/td[3]"));
		List<WebElement> modernizer = driver.findElements(By.xpath("//div[@class='render']//tbody/tr/td[4]"));

		for (int i = 0; i < library.size(); i++) {
			System.out.println(library.get(i).getText() + " values are :");
			System.out.println(
					jquery.get(i).getText() + " " + bootstrap.get(i).getText() + " " + modernizer.get(i).getText());
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
