package week4.day1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		List<WebElement> headerElements = driver.findElements(By.xpath("//table//tr/th"));
		System.out.println("Number of columns :" + headerElements.size());
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		System.out.println("Number of rows :" + (rows.size() - 1));
		int temp_percentage = 100;
		int temp_i = 0;
		for (int i = 2; i <= rows.size(); i++) {
			String detail = driver.findElement(By.xpath("//table//tr[" + i + "]/td[1]")).getText();
			String progress = driver.findElement(By.xpath("//table//tr[" + i + "]/td[2]")).getText();
			if (detail.equals("Learn to interact with Elements"))
				System.out.println(progress);
			int progressAsInt = Integer.parseInt(progress.replaceFirst("%", ""));
			System.out.println("progressAsInt"+ progressAsInt);
			if (progressAsInt < temp_percentage) {
				temp_percentage = progressAsInt;
				temp_i = i;
			}

		}
		driver.findElement(By.xpath("//table//tr[" + temp_i + "]/td[3]")).click();
	}
}

