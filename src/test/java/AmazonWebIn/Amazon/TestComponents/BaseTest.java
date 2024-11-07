package AmazonWebIn.Amazon.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import AmazonWebIn.pageobjects.landingPage;
import AmazonWebIn.pageobjects.signout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public landingPage lp;
	public signout so;
	
	public WebDriver initializeDriver() throws IOException
	{
	
	Properties prop=new Properties();
	FileInputStream Fis = new FileInputStream(System.getProperty("user.dir") +"//src//main//java//AmazonWebIn//resources//GlobalData.properties");
	prop.load(Fis);
	String browserName = prop.getProperty("browser");
	{
		if(browserName.equalsIgnoreCase("chrome")) 
		{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
		}
	else if(browserName.equalsIgnoreCase("firefox"))
		{
		//firefox
		}
	else if(browserName.equalsIgnoreCase("edge"))
		{
		//edge
		}
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
		}
	return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//AmazonWebIn//Amazon//data//purchaseOrder.json"),StandardCharsets.UTF_8);
	
	ObjectMapper mapper = new ObjectMapper();
		
	
	
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {

		});
		return data;
	}
	
	public String getScreenshot(String errorSS,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+errorSS+".png");
		FileUtils.copyFile(source, file);
		
		return System.getProperty("user.dir")+"//reports//"+errorSS+".png";
	}

	
	@BeforeMethod(alwaysRun=true)
	public landingPage launchApplication() throws IOException 
			{
			initializeDriver();
			lp = new landingPage(driver);
			lp.goTo();
			return lp;
			}
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		driver.close();
	}
}