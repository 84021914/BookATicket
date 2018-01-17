package pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.ExplicitWait;

public class homePage {

	WebDriver driver;
	@FindBy(id="sign-in-icon-down")
	private WebElement signInLinkDropDown;
	@FindBy(id="signInLink")
	private WebElement signInLink;
	@FindBy(id="src")
	private WebElement fromObject;
	@FindBy(id="dest")
	private WebElement toObject;
	@FindBy(id="onward_cal")
	private WebElement onwardDate;
	@FindBy(id="search_btn")
	private WebElement searchButton;
	@FindBy(xpath="//ul[@class='autoFill']//li")
	private List<WebElement> fromMenuList;
	@FindBy(xpath="//div[@id='rb-calendar_onward_cal']//td[@class='monthTitle']")
	private  WebElement monthTitle;
	@FindBy(xpath="//div[@id='rb-calendar_onward_cal']//td[@class='next']")
	private  WebElement nextMonth;
	@FindBy(xpath="//div[@id='rb-calendar_onward_cal']//td")
	private List<WebElement> dateList;
	public homePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public SigninPage clickOnSignIn()
	{
		signInLinkDropDown.click();
		ExplicitWait.clickOn(driver, signInLink, 20);
		//signInLink.click();
		SigninPage l= new SigninPage(driver);
		return l;
	}
	public homePage enterBoardingPoint(String from)
	{
		
		fromObject.sendKeys(from);
		for(WebElement ele:fromMenuList)
		{
			if(ele.getText().equals(from))
			{
				ele.click();
				break;
			}
		}
		return this;
	}
	public homePage enterDestination(String to)
	{
		toObject.sendKeys(to);
		for(WebElement ele:fromMenuList)
		{
			if(ele.getText().equals(to))
			{
				ele.click();
				break;
			}
		}
		return this;
	}
	public homePage enterOnWardDate(String date)
	{
		String dateSplit[]=date.split("-");

		onwardDate.sendKeys(date);
		String actualMonthTitle=monthTitle.getText();
		while(actualMonthTitle.equals(dateSplit[1]+" "+dateSplit[2])!=true)
		{
			nextMonth.click();
			actualMonthTitle=monthTitle.getText();
		}
		for (int i=0;i<dateList.size();i++)
		{
			if(dateList.get(i).getText().equals(dateSplit[0]))
			{
				dateList.get(i).click();
				break;
			}
		}
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('data-caleng','"+date+"');", onwardDate);
		*/return this;
	}
	public homePage clickOnSearch()
	{
		searchButton.click();
		return this;
	}
}
