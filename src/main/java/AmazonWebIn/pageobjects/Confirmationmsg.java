package AmazonWebIn.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmationmsg {
	WebDriver driver;
	public Confirmationmsg(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".a-alert-heading")
	WebElement cnfmsg;
	
	public String confmsg()
	{
		String Conformation = cnfmsg.getText();
		return Conformation;
	}
	
	
}