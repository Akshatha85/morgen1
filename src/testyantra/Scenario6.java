package testyantra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.bluestone.com");
		
		WebElement ring = driver.findElement(By.xpath("(//a[@title='Rings'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(ring).perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Diamond Rings']")).click();

	}

}
