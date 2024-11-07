package AmazonWebIn.Amazon.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class endtoendTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String ProductName = "Minimalist 10% Niacinamide Face Serum";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.className("a-input-text")).sendKeys("number");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("PWD");
		driver.findElement(By.id("signInSubmit")).click();
		String Name = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		System.out.println(Name + " " + " Loged-in Succesfully");
				
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Minimalist Face Serum");
		driver.findElement(By.id("nav-search-submit-button")).click();

		List<WebElement> Products = driver.findElements(By.xpath("//*[contains(@class, 'puis-card-container')]"));
		WebElement Needed = Products.stream().filter(Product->Product.findElement(By.className("a-size-mini")).getText().contains(ProductName)).findFirst().orElse(null);
		Needed.findElement(By.className("a-button-text")).click();
		
		String Confirmation = driver.findElement(By.className("a-changeover-inner")).getText();
		if(Confirmation.equalsIgnoreCase("Item Added"))
		{
			driver.findElement(By.id("nav-cart-count")).click();
		}
		List<WebElement> CartItems = driver.findElements(By.className("sc-list-item-content-inner"));
		Boolean Match = CartItems.stream().anyMatch(cartItem->cartItem.getText().contains(ProductName));
		Assert.assertTrue(Match);
		driver.findElement(By.id("sc-buy-box-gift-checkbox")).click();
		driver.findElement(By.className("a-button-input")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#orderSummaryPrimaryActionBtn"))).click();		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#orderSummaryPrimaryActionBtn"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#orderSummaryPrimaryActionBtn"))).click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submitOrderButtonId"))).click();
		Thread.sleep(5000);
		String Verify = driver.findElement(By.cssSelector(".a-alert-container")).getText();
		System.out.println(Verify);
		}
}