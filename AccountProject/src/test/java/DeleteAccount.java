import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class DeleteAccount {
	
	// there needs to be accounts avaiable to delete for his test to run please create an account using the 
	// AddingAccount.java

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	
	@Test
	public void test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/AccountProject/showall.html");
		Thread.sleep(2000);
		
		WebElement delete = driver.findElement(By.cssSelector("#deletebtn"));
		delete.click();
		
		Thread.sleep(2000);
		String actual = driver.switchTo().alert().getText();
		System.out.println(actual);
		String expected = "account deleted";
		Assert.assertEquals(expected, actual);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.close();
		
	}

}
