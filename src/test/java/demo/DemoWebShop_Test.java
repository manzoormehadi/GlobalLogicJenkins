package demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWebShop_Test {
	WebDriver driver;
	@BeforeClass
	public void launchApplication()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}
  @Test
  public void login() {
	  driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("globallogic@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("global");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		String text=driver.findElement(By.linkText("globallogic@gmail.com")).getText();
		assertEquals(text, "globallogic@gmail.com");
  }
  @AfterClass
  public void logout()
  {
	  driver.findElement(By.linkText("Log out")).click();
	  driver.close();
  }
}
