package testyantra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Flip {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("c# books",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		
		List<WebElement> prise = driver.findElements(By.xpath("//div[@class='_1uv9Cb']/descendant::div[@class='_1vC4OE']"));
		for(WebElement cost:prise)
		{	
			String str = cost.getText();
			String str1 = str.substring(1);
			System.out.println(str1);
		}
		
	}

}
