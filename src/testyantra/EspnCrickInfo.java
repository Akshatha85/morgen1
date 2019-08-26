package testyantra;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class EspnCrickInfo {
	
		public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException 
		{
//			Properties p=new Properties();
//			p.load(new FileInputStream("./file.properties"));
//			String s=p.getProperty("url");
			WebDriver driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();	
			driver.get("https://www.espncricinfo.com/");
			
			Thread.sleep(10000);
		
			driver.findElement(By.xpath("//div[@class=\"scores-next controls\"]")).click();
			Actions a=new Actions(driver);
			
			Thread.sleep(2000);
			WebElement how = driver.findElement(By.xpath("(//a[@class=\"cscore_link\"])[7]"));
			a.moveToElement(how).perform();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@class=\"cscore_header-link\"])[13]")).click();
			
			List<WebElement> batsmen1 = driver.findElements(By.xpath("//div[@id='gp-inning-00']/descendant::div[@class='scorecard-section batsmen']/descendant::div[@class='flex-row']/descendant::div[@class='cell batsmen']"));
			for(WebElement a1:batsmen1)
			{	
				Thread.sleep(2000);
				System.out.print(a1.getText());
				List<WebElement> li2 = driver.findElements(By.xpath("//div[@id='gp-inning-00']/descendant::div[@class='scorecard-section batsmen']/descendant::div[@class='flex-row']/descendant::div[.='"+a1.getText()+"']/following-sibling::div"));
				for(WebElement a2:li2)
				{
					System.out.print("	"+a2.getText());
				}
				System.out.println();
			}
			
	        //List<WebElement> secondRow=driver.findElements(By.xpath("//div[@id='gp-inning-00']/descendant::div[@class='scorecard-section batsmen']/descendant::div[@class='flex-row']/descendant::div[@class='cell batsmen']/following-sibling::div[@class='cell commentary']"));

	       // List<WebElement> runsDetails=driver.findElements(By.xpath("//div[@id='gp-inning-00']/descendant::div[@class='scorecard-section batsmen']/descendant::div[@class='flex-row']/descendant::div[@class='cell batsmen']/following-sibling::div[@class='cell commentary']/following-sibling::div[@class='cell runs']"));
		}

	}


