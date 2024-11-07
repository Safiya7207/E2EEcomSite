package AmazonWebIn.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonWebIn.Abstract.abstractComponents;

public class cartFilters extends abstractComponents{
	
	WebDriver driver;
	
	public cartFilters(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="sc-buy-box-gift-checkbox")
	WebElement prodfltr;
	
	@FindBy(className="a-button-input")
	WebElement btnclick;

	
	public void prodFilter()
	{
		prodfltr.click();
		btnclick.click();
	}

}
