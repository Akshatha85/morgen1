package testyantra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("gpraveenkumar001@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("praveen103",Keys.ENTER);
		WebElement str = driver.findElement(By.xpath("(//div[@class='aio UKr6le'])[1]"));
		System.out.println(str);
		
		
//		WebElement inbox = driver.findElement(By.xpath("//a[text()='Inbox']"));
//		inbox.getAttribute("Inbox");//input[@name='password']
	}

}
