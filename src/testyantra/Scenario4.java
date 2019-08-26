package testyantra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scenario4 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.ebay.com/");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Apple Watches");
		driver.findElement(By.xpath("//div[@id='gh-cat-box']")).click();
		driver.findElement(By.xpath("//option[text()='Jewelry & Watches']")).click();
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		WebElement res = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
		
		System.out.println("The result of the product is:"+res.getText());
		
		System.out.println("List of product");
		List<WebElement> result = driver.findElements(By.xpath("//div[@id='srp-river-results']/descendant::a[@class='s-item__link']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(WebElement product:result)
		{
			System.out.println(product.getText());
			js.executeScript("window.scrollBy(0,100)");
		}
		WebElement nthproduct = driver.findElement(By.xpath("//li[@data-view='mi:1686|iid:20']"));
		System.out.println("");
		System.out.println(nthproduct.getText());
	}

}
