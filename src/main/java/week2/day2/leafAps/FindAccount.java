package week2.day2.leafAps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAccount {

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

		// Find Account
		driver.findElement(By.linkText("Find Accounts")).click();
		driver.findElement(By.xpath("//label[text()='Account ID:']/following::input[2]"))
				.sendKeys("Credit Limited Account");
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		driver.findElement(By.xpath("//td//a[text()='Credit Limited Account']")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
		String text = driver.findElement(By.id("accountName")).getAttribute("value");
		System.out.println(text);
		if (text.equals("Credit Limited Account"))
			System.out.println("Account name is verified");
		System.out.println(driver.findElement(By.xpath("//textarea[@name='description']")).getText());
		String title = driver.getTitle();
		if (title.equals("Edit Account | opentaps CRM"))
			System.out.println("Title verified");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.close();
	}

}
