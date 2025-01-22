package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SigninEmailMobile{
	private WebDriver driver;
	
	@FindBy(xpath="//h1[contains(text(),'Sign in')]")
	private WebElement signInText;
	
	@FindBy(id="ap_email")
	private WebElement emailText;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	public SigninEmailMobile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPageTitle() {
		return driver.getTitle().contains("Amazon Sign In");
	}
	
	public void inputPhone(String phoneNumber) {
		emailText.sendKeys(phoneNumber);
	}
	
	public SigninPassword clickContinue() {
		continueButton.click();
		System.out.println("master22");
		System.out.println("test 22");
		return new SigninPassword(driver);
		
	}

}
