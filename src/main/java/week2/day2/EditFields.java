package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.id("email")).sendKeys("vidhyavishali.kv@gmail.com");
		WebElement appendElement = driver.findElement(By.xpath("//input[contains(@value,'Append')]"));
		appendElement.sendKeys(appendElement.getText() + " Extra text" + Keys.TAB);

		String text = driver.findElement(By.xpath("//label[contains(text(),'default text')]/following-sibling::input"))
				.getAttribute("value");
		System.out.println(text);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).sendKeys("");
		if (!driver.findElement(By.xpath("//label[contains(text(),'is disabled')]/following-sibling::input"))
				.isEnabled())
			System.out.println("Confirming the field is disabled");
		
		driver.close();
	}

}
