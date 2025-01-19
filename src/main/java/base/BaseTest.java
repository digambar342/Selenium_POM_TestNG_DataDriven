package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import config.Config;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod
	public void setup(ITestContext context) throws IOException {
		System.setProperty("webdriver.chrome.driver",Config.getChromeDriverPath());
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getURL());
		context.setAttribute("driver", driver);
	}
	@AfterTest
	public void tearDown() {
		if(driver !=null)
		driver.quit();
	}

}
