package AmazonWebIn.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchEle {
	WebDriver driver;
public searchEle(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(css="#twotabsearchtextbox")
WebElement prodsrch;

@FindBy(css="#nav-search-submit-button")
WebElement srch;

public void srchingprod(String product)
{
	prodsrch.sendKeys(product);
	srch.click();
}
}
