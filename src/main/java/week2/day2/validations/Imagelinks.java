package week2.day2.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imagelinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Image.html");
		
		//click the image to go to home
		driver.findElement(By.xpath("//label[contains(text(),'Click on this image to go home page')]/following::img")).click();
		
		
		
		
	}
}
