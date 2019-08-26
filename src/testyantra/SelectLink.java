package testyantra;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectLink {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("java",Keys.ENTER);
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for(WebElement link:links)
		{
			
			if(link.getAttribute("href")!=null)
			{
				Thread.sleep(1000);
			System.out.println(link.getText());
			String lnk = link.getAttribute("href");
			System.out.println(lnk);
			URL u = new URL(lnk);
			URLConnection ulnk = u.openConnection();
			HttpURLConnection connection = (HttpURLConnection)ulnk;
			int rcode = connection.getResponseCode();
//			Assert.assertEquals(200, rcode);
			if(rcode==200)
			{
				System.out.println(rcode);
				System.out.println(connection.getResponseMessage());
				System.out.println("link is not broken");
			}
			else
			{
				System.out.println(rcode);
				System.out.println(connection.getResponseMessage());
				System.out.println("link is broken");
			}
			}
		}

	}

}
