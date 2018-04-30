import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class NavigationTest {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		
	}
	
	
	@Test
	public void test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/AccountProject/");
		Thread.sleep(2000);
		
		WebElement linkshowAll = driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(2) > a"));
		linkshowAll.click();
		
		Thread.sleep(2000);
		
		WebElement linkaddAccount = driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(3) > a"));
		linkaddAccount.click();
		
		Thread.sleep(2000);
		int counter = 0;
		counter++;
		
		Assert.assertEquals(1, counter);
		
		driver.close();
	}

}
