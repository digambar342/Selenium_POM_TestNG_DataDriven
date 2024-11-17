package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utilities;

public class SigninPassword {
	
	private WebDriver driver;
	@FindBy(id="ap_password")
	private WebElement passwordText;
	
	@FindBy(xpath="//a[contains(text(),'Forgot password?')]")
	private WebElement forgotPasswordLink;
	
	public SigninPassword(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputPassword(String Password) {
		passwordText.sendKeys(Password);
	}
	public void clickOnForgotPasswordLink() {
		Actions actions=new Actions(driver);
		actions.moveToElement(forgotPasswordLink).keyDown(Keys.CONTROL).click().build().perform();
	}
	
	public boolean verifyForgotPasswordTitle() {
		String currentWindow = driver.getWindowHandle();
		driver.switchTo().window(Utilities.returnNextWindows(driver));
		String forgotPasswordTitle = driver.getTitle();
		driver.switchTo().window(currentWindow);
		return forgotPasswordTitle.contains("Password");
	}
	public boolean verifySigninTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle().contains("Sign In");
	}

}
