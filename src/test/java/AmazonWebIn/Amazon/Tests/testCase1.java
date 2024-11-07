package AmazonWebIn.Amazon.Tests;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AmazonWebIn.Amazon.TestComponents.BaseTest;
import AmazonWebIn.pageobjects.cartFilters;
import AmazonWebIn.pageobjects.checkOut;
import AmazonWebIn.pageobjects.productcatlog;
import AmazonWebIn.pageobjects.searchEle;

public class testCase1 extends BaseTest{
	
	String ProductName = "Minimalist 10% Vitamin C Face Serum";
	String product ="Minimalist Face Serum";
	

@Test(dataProvider="getData")
public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException
{
		lp.lpvalues(input.get("email"), input.get("password"));
		searchEle se = new searchEle(driver);
		se.srchingprod(product);
		productcatlog pc = new productcatlog(driver);
		pc.getProductList();
		pc.getProductName(input.get("ProductName"));
		pc.Neededproduct(input.get("ProductName"));
		pc.cartitems();
		cartFilters cf = new cartFilters(driver);
		cf.prodFilter();
		checkOut co = new checkOut(driver);
		co.finalcheck();
//		Thread.sleep(8000);		
//		co.finalcheck1();
//		Thread.sleep(8000);		
//		co.finalcheck2();
//		Thread.sleep(10000);		
//		co.submitbtn();
//		Thread.sleep(5000);		
//		Confirmationmsg cfm = new Confirmationmsg(driver);
//		String FinalConf = cfm.confmsg();
//		Assert.assertTrue(FinalConf.equalsIgnoreCase("Order placed, thank you!"));
//		Thread.sleep(10000);
//		signout so = new signout(driver);
//		so.sigingoff();
}


@DataProvider
public Object[][] getData() throws IOException
{
	List<HashMap<String,String>> data =getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//AmazonWebIn//Amazon//data//purchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
}
}
//@DataProvider
//public Object[][] getData()
//{
//	return new Object[][] {{"number","PWD","Minimalist 10% Vitamin C Face Serum"},{"number","PWD2","Minimalist 10% Vitamin C Face Serum"}};
//	
//}
//or
//HashMap<String,String> map = new HashMap<String,String>();
//map.put("email", "num");
//map.put("password", "PWD");
//map.put("ProductName", "Minimalist 10% Vitamin C Face Serum");
//
//HashMap<String,String> map1 = new HashMap<String,String>();
//map1.put("email", "num1");
//map1.put("password", "pwd");
//map1.put("ProductName", "Minimalist 10% Vitamin C Face Serum");

