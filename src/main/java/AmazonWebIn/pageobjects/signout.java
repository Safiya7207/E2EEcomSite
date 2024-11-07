package AmazonWebIn.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signout {
WebDriver driver;
	
	public signout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="i.hm-icon.nav-sprite")
	WebElement barmenuclick;
	
	@FindBy(css="ul.hmenu.hmenu-visible")
	List<WebElement> barmenuoptions;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement SnOut;

	public void sigingoff()
	{
		barmenuclick.click();
		barmenuoptions.contains(SnOut);
		SnOut.click();
	}
}
