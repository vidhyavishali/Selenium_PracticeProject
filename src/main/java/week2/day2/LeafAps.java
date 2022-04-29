package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafAps {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited AccountV");
		driver.findElement(By.xpath("//table[@class='fourColumnForm']//tr[9]/td[2]/textarea")).sendKeys("Selenium Automation TesterV");
		
		String localNameXPath ="//table[@class='fourColumnForm']//tr[2]//input";
		driver.findElement(By.xpath(localNameXPath+"/following::input[1]")).sendKeys("SiteNameV");
		driver.findElement(By.xpath("//table[@class='fourColumnForm']//tr[3]//input[@class='inputBox']")).sendKeys("30000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='fourColumnForm']//tr[22]//input")).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.close();
		
	}

}
