package AmazonWebIn.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonWebIn.Abstract.abstractComponents;

public class landingPage extends abstractComponents{
	
	WebDriver driver;

	
	public landingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} //pagefactory
	
	@FindBy(css="#nav-link-accountList")
	WebElement Acountclick;
	
	@FindBy(className="a-input-text")
	WebElement username;
	
	@FindBy(id="continue")
	WebElement cont1;
	
	@FindBy(id="ap_password")
	WebElement passwordd;
	
	@FindBy(id="signInSubmit")
	WebElement signin;
	
//	@FindBy(id="nav-link-accountList-nav-line-1")
//	WebElement loginconf;
	
	public void lpvalues(String mail,String password)
	{
		Acountclick.click();
		username.sendKeys(mail);
		cont1.click();
		passwordd.sendKeys(password);
		signin.click();
//		loginconf.getText();
	}
	
	public void goTo()
	{
		driver.get("https://www.amazon.in/");
	}
}
