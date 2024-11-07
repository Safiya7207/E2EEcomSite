package AmazonWebIn.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AmazonWebIn.Abstract.abstractComponents;

public class checkOut extends abstractComponents {
WebDriver driver;

	
	public checkOut(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	By Click =  By.cssSelector("#orderSummaryPrimaryActionBtn");
	By Click1 = By.cssSelector("#orderSummaryPrimaryActionBtn");
	By Click2 = By.cssSelector("#orderSummaryPrimaryActionBtn");
	By submit = By.cssSelector("#submitOrderButtonId");

	public void finalcheck()
	{
		waitForElementToClick(Click);
	}
	public void finalcheck1()
	{
		waitForElementToClick(Click1);
	}
	public void finalcheck2()
	{
		waitForElementToClick(Click2);
	}
	public void submitbtn()
	{
		waitForElementToClick(submit);
	}
}