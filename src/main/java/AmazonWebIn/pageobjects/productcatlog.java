package AmazonWebIn.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonWebIn.Abstract.abstractComponents;

public class productcatlog  extends abstractComponents{
		
		WebDriver driver;
		
public productcatlog(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		} //pagefactory
		
		@FindBy(xpath="//*[contains(@class, 'puis-card-container')]")
		List<WebElement> products;
				
		By productsBy = By.xpath("//*[contains(@class, 'puis-card-container')]");
		By addtoCartbtn = By.className("a-button-text");
		By itemaddedMessage = By.className("a-changeover-inner");
		
		
		
public List<WebElement> getProductList()
		{
		waitForElementToAppear(productsBy);
			return products;
		}
		
public WebElement getProductName(String ProductName)
		{
			WebElement Neededprod = getProductList().stream().filter(Product->Product.findElement(By.className("a-size-mini")).getText().contains(ProductName)).findFirst().orElse(null);
			return Neededprod;
		}
		
public void Neededproduct(String ProductName)
			{
				WebElement Needprod = getProductName(ProductName);
				Needprod.findElement(addtoCartbtn).click();
				waitForElementToAppear(itemaddedMessage);
			}

public void cartitems()
			{
			driver.findElement(By.id("nav-cart-count")).click();
			}
		}
