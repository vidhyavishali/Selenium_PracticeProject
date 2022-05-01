package week2.day2.leafAps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NTAccountErrorMessage {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();

		// NTCreateAccount
		driver.findElement(By.linkText("Create Account")).click();
		// driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("NRI
		// AccountV");
		WebElement findElement = driver.findElement(By.id("currencyUomId"));
		Select selectCurrency = new Select(findElement);
		selectCurrency.selectByValue("INR");
		driver.findElement(By.xpath("//table[@class='fourColumnForm']//tr[9]/td[2]/textarea")).sendKeys("NRI Account");
		driver.findElement(By.id("groupNameLocal")).sendKeys("LocalNameNRIV");
		driver.findElement(By.xpath("//table[@class='fourColumnForm']//tr[2]//input/following::input[1]"))
				.sendKeys("SiteNameNRIV");
		driver.findElement(By.xpath("//table[@class='fourColumnForm']//tr[22]//input")).click();
		String errorMessage = driver.findElement(By.xpath("//div[@id='nav1']/following-sibling::div//div//li"))
				.getText();

		System.out.println(errorMessage);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.close();
	}
}
