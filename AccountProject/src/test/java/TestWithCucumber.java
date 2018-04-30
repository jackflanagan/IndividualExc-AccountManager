import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestWithCucumber {

	private static WebDriver driver;
	
	@Given("^I am at the show all page")
	public void action() {
		 driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("http://localhost:8080/AccountProject/showall.html");
		driver.manage().window().maximize();
		
	}
	
	@When("^I add details to be edited and submitted change$")
	public void action1() throws InterruptedException {
		
		Thread.sleep(2000);
		
		WebElement id = driver.findElement(By.cssSelector("#editID"));
		id.sendKeys("1");
		WebElement fname = driver.findElement(By.cssSelector("#editfirstName"));
		fname.sendKeys("Chad");
		WebElement sname = driver.findElement(By.cssSelector("#editsecondName"));
		sname.sendKeys("Thompson");
		WebElement accno = driver.findElement(By.cssSelector("#editaccountNumber"));
		accno.sendKeys("666");
		Thread.sleep(2000);
		WebElement editbtn = driver.findElement(By.cssSelector("#editbtn"));
		editbtn.click();
		
	}
	
	@Then("^I validate the outcomes$")
	public void action2() throws InterruptedException {
		Thread.sleep(2000);
		String actual = driver.switchTo().alert().getText();
		String expected = "account updated";
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(expected, actual);
		
		driver.close();
		
		
	}
	
	
}
