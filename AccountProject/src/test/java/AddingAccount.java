import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AddingAccount {

	
	
	
WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		
	}
	
	@Test
	public void test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/AccountProject/addaccount.html");
		Thread.sleep(2000);
		
		//*[@id="editID"]
		
		WebElement fname = driver.findElement(By.cssSelector("#firstName"));
		fname.sendKeys("Jack");
		
		WebElement sname = driver.findElement(By.cssSelector("#secondName"));
		sname.sendKeys("Flanagan");
		
		WebElement accountno = driver.findElement(By.cssSelector("#accountNumber"));
		accountno.sendKeys("55267");
		
		Thread.sleep(2000);
		
		WebElement addbtn = driver.findElement(By.cssSelector("#add-account"));
		addbtn.click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		WebElement showall = driver.findElement(By.cssSelector("body > nav > div > ul > li:nth-child(2) > a"));
		showall.click();
		
		Thread.sleep(3000);
		
		WebElement getAccount = driver.findElement(By.cssSelector("#data > li"));
		
		if(getAccount.isDisplayed()) {
			int counter = 0;
					counter++;
					Assert.assertEquals(1, counter);
					driver.close();
		}
		
		
		
		
		
	}

}
