package stepDefination;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AmazonWebIn.Amazon.TestComponents.BaseTest;
import AmazonWebIn.pageobjects.Confirmationmsg;
import AmazonWebIn.pageobjects.cartFilters;
import AmazonWebIn.pageobjects.checkOut;
import AmazonWebIn.pageobjects.landingPage;
import AmazonWebIn.pageobjects.productcatlog;
import AmazonWebIn.pageobjects.searchEle;
import AmazonWebIn.pageobjects.signout;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationImpl extends BaseTest{
	
	public landingPage lp; 
	public productcatlog pc;
	public cartFilters cf;
	public checkOut co;
	public Confirmationmsg cfm ;
	public signout so;
	public  WebElement errormsg;
	
	@Given ("landing on Amazon Ecommerce Website")
	public void landing_on_Amazon_Ecommerce_Website() throws IOException
	{
       lp = launchApplication();
	}
	
	 @Given ("^Logged in with username (.+) and password (.+)$")
	 public void  Logged_in_with_credentials(String mail,String password)
	 {
		 lp.lpvalues(mail, password);
		
	 }
	 
	 @When ("^(.+) user searching the product$")
	 public void user_searching_the_product(String Product)
	 {
		 searchEle se = new searchEle(driver);
		 se.srchingprod(Product);
	 }
	 
	 @When ("^checkout (.+) and submit the order$")
	 public void checkout_productName_and_submit_the_order(String productName) throws InterruptedException
	 {
		 	pc = new productcatlog(driver);
			pc.getProductList();
			pc.getProductName(productName);
			pc.Neededproduct(productName);
			pc.cartitems();
			cf = new cartFilters(driver);
			cf.prodFilter();
			co = new checkOut(driver);
			co.finalcheck();
			Thread.sleep(8000);		
			co.finalcheck1();
			Thread.sleep(8000);		
			co.finalcheck2();
			Thread.sleep(10000);		
			co.submitbtn();
			Thread.sleep(5000);		
	 }
	 @Then ("^the (.+) message is displayed on confirmationPage$")
	 public void the_confirmation_message_is_displayed_on_confirmationPage(String confirmation) throws InterruptedException
	 {
		 	cfm = new Confirmationmsg(driver);
			String FinalConf = cfm.confmsg();
			Assert.assertTrue(FinalConf.equalsIgnoreCase("Order placed, thank you!"));
			Thread.sleep(10000);
			so = new signout(driver);
			so.sigingoff();
	 }
	 
	 @Then ("^(.+) message is displayed$")
	 public void error_message_is_displayed(String errormsgg)
	 {
		  	errormsg =driver.findElement(By.cssSelector(".a-alert-content"));
			String errorcnf = errormsg.getText();
			Assert.assertEquals(errorcnf, errormsgg);
	 }
	 
	 @Then ("extracting the title")
	 public void extracting_the_title()
	 {
		 System.out.println(driver.getTitle());
	 }
	
}