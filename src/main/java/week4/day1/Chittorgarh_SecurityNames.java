package week4.day1;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh_SecurityNames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		// collect all the table row elements into list
		/*
		 * WebElement tbody =
		 * driver.findElement(By.xpath("//div[@class='table-responsive']"));
		 * List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		 */

		Thread.sleep(3000);
		/*
		 * 1. The above method to reach <tr> and then retrieving <td> using tr's
		 * webelement does not work for all the dob structures. So reaching till
		 * destination td using xpath is optimal. 2. The class name with space can be
		 * used in case of xpath, if all entire class phase is copied.
		 */
		List<WebElement> columns = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[3]"));
		Set<String> columnSet = new HashSet<String>();
		// iterate every row, get third td element( security name is the third column)
		// and print them.
		System.out.println("Available security names are..");
		
		/* Convert the list to set to remove duplicates */
		for (WebElement row : columns) {
			columnSet.add(row.getText());
		}
		if (columns.size() == columnSet.size())
			System.out.println("duplicates not removed");
		System.out.println(columnSet);
	}

}
