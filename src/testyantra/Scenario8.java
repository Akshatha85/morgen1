package testyantra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.bluestone.com");
		
		Thread.sleep(2000);
		WebElement jewellary = driver.findElement(By.xpath("//li[@class='menuparent']"));
		Actions act = new Actions(driver);
		act.moveToElement(jewellary).perform();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='two-column']/descendant::a[text()='Kadas']")).click();
		driver.findElement(By.xpath("(//div[@id='grid-view-result'])[1]/descendant::div[@class='p-image']/descendant::a[@id='pid_5668']")).click();

		driver.findElement(By.xpath("//span[text()='2-6(2 6/16\")']")).click();

		
		driver.findElement(By.xpath("//span[@class='size-box-overlay']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='buynow-block col-xs-7']")).click();

	}

}
