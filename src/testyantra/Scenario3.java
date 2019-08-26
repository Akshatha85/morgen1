package testyantra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Scenario3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions act= new Actions(driver);
		act.dragAndDrop(source, target).perform();
		System.out.println("Drag & Dropped");
		WebElement dropped = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		String c = dropped.getCssValue("color");
		System.out.println(c);
		String actual = "rgb(119, 118, 32)";
		Assert.assertEquals(actual, c);
		System.out.println("Color and text are expected");
	}

}
