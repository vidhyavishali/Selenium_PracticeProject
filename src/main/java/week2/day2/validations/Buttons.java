package week2.day2.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Button.html");
		// CLick the home page button
		String link = driver.findElement(By.id("home")).getAttribute("onclick");
		System.out.println(link);
		driver.findElement(By.id("home")).click();
		if (driver.getCurrentUrl().equals("http://leafground.com/home.html"))
			System.out.println("Goes to correct link");
		
		// click off button to go back to old URL
		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		
		//get the position of the button
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println(location.getX() + ", " + location.getY());
		
		// get the background color of the button
		String color = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println(color);
		
		// get the size coordinates of the button
		Dimension size = driver.findElement(By.id("size")).getSize();
		System.out.println(size.getHeight() + ", " + size.getWidth());

		driver.close();

	}

}
