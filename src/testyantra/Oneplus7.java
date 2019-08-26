package testyantra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Oneplus7 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("oneplus 7",Keys.ENTER);
		Thread.sleep(2000);
		
		String str = "OnePlus 7 Pro: Everything you need to know! | Android Central";	
		int f =0;
		for(int i=1;;i++)
		{
			List<WebElement> links = driver.findElements(By.xpath("//h3[@class='LC20lb']/descendant::div[contains(text(),'OnePlus 7')]"));
			for(WebElement link:links)
			{
				String text = link.getText();
				//System.out.println(text);
				if(str.equals(text))
				{
					driver.findElement(By.xpath("//h3[@class='LC20lb']/descendant::div[contains(text(),'OnePlus 7 Pro: Everything you need to know!')]")).click();
					f=1;
					break;
				}
				
			}
			if(f==1)
			{
				break;
			}
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
		
	}	
	}
