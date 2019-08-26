package testyantra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 {

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
		
		System.out.println("prise list");
		Thread.sleep(1000);
		List<WebElement> prise = driver.findElements(By.xpath("//div[@id='grid-view-result']/descendant::span[@class='b-price-wrapper']"));
		for(WebElement value:prise)
		{
			String dv = value.getText();
			System.out.println(dv);
//			int dev = Integer.parseInt(dv);
//			System.out.println(dev);
		}
		Thread.sleep(2000);
		WebElement mover = driver.findElement(By.xpath("//section[@class='block sort-by pull-right']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(mover).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Price Low to High ']")).click();
		
		System.out.println("sorted prise");
		Thread.sleep(1000);
		List<WebElement> sprise = driver.findElements(By.xpath("//div[@id='grid-view-result']/descendant::span[@class='b-price-wrapper']"));
		
		for(WebElement value1:sprise)
		{
			String sv = value1.getText();
//			int sov = Integer.parseInt(sv);
//			System.out.println(sov);	
			System.out.println(sv);
		}
		int dp = prise.size();
		int sp = sprise.size();
		System.out.println(dp);
		System.out.println(sp);
//		String[][] a = new String[dp][sp];
//	
//		for(int i=0;i<dp;i++)
//		{
//			for(int j=0;j<sp;j++)
//			{
//			 
//			}
//		}
	}

}
