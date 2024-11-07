package AmazonWebIn.Amazon.Tests;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AmazonWebIn.Amazon.TestComponents.BaseTest;
import AmazonWebIn.Amazon.TestComponents.retry;

public class errorValidation extends BaseTest{

@Test(groups= {"errorHandling"},retryAnalyzer=retry.class)
public void error() throws InterruptedException, IOException
{
		lp.lpvalues("num", "INCORRECTPWD");
		WebElement errormsg =driver.findElement(By.cssSelector(".a-alert-content"));
		String errorcnf = errormsg.getText();
			Assert.assertEquals(errorcnf, "Your passwordD is incorrect");
			{
			System.out.println("Sorry invalid credentials");
			}
}
}