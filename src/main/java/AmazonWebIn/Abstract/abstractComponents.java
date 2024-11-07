package AmazonWebIn.Abstract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class abstractComponents {
	
	WebDriver driver;
	public abstractComponents(WebDriver driver) {
		this.driver=driver;
}
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToClick(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
		
	}
	
	public void implicit()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void asserttrue()
	{
	Assert.assertTrue(true);
	}
}
