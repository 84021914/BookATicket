package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.ExplicitWait;

public class SigninPage {

	WebDriver driver;
	@FindBy(linkText="SIGN IN")
	private WebElement signInLink;
	@FindBy(xpath="//iframe[@class='modalIframe']")
	private WebElement SignInFrame;
	@FindBy(xpath="(//iframe[@class='modalIframe'])[2]")
	private WebElement SignInFrame2;
	@FindBy(id="email-mobile")
	private WebElement userName;
	@FindBy(id="password")
	private WebElement passWord;
	@FindBy(id="doSignin")
	private WebElement signInButton;
	@FindBy(xpath="(//div[@class='modalFrame'])[2]//i[@class='icon-close']")
	private WebElement closeFrameLink;
	
	public SigninPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public SigninPage clickOnSignin()
	{
		driver.switchTo().frame(SignInFrame);
		signInLink.click();
		return this;
	}
	public homePage enterCredentials(String usrName,String Pwd) 
	{
		userName.sendKeys(usrName);
		passWord.sendKeys(Pwd);
		signInButton.click();
		driver.switchTo().defaultContent();
		ExplicitWait.wiatForFrameAndSwitcToit(driver, SignInFrame2, 10);
		driver.navigate().refresh();
		homePage l= new homePage(driver);
		return l;
	}
}
