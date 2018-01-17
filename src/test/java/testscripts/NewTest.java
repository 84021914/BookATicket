package testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.PropHandler;
import pageobjects.homePage;





public class NewTest {
	WebDriver driver;
	String from;
	String to;
	homePage l;
	String date;
  @BeforeClass
  public void precondition()  {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		l= new homePage(driver);
		l.clickOnSignIn()
		.clickOnSignin().enterCredentials("bcrishna30@gmail.com", "Bkrishna@1523");
		from=PropHandler.getProperties("From");
		to=PropHandler.getProperties("To");
		date=PropHandler.getProperties("Date");
		
  }
  @Test
  public void bookTicket()
  {l.enterBoardingPoint(from)
	  .enterDestination(to)
	  .enterOnWardDate(date)
	  .clickOnSearch();
	  
  }
  @AfterClass
  public void tearDown()
  {
/*	 driver.close();
	  driver.quit();*/
  }
}
