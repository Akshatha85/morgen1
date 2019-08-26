package testyantra;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindBrokenLink {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/admin/Desktop/F1.html");
		WebElement lnk1 = driver.findElement(By.xpath("//a[text()='selenium']"));
		String lnk = lnk1.getAttribute("href");
		URL u = new URL(lnk);
		URLConnection ulnk = u.openConnection();
		HttpURLConnection connection = (HttpURLConnection)ulnk;
		int rcode = connection.getResponseCode();
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
