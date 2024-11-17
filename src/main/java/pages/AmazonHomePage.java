package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonHomePage{
	private WebDriver driver;
	@FindBy (xpath="//span[contains(text(),'Hello, sign in')]")
	private WebElement helloSignIn;
	@FindBy (xpath="//span[contains(text(),'Sign in')]")
	private WebElement signIn;
	
	public AmazonHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean verifyTitle() {
		return driver.getTitle().contains("Online Shopping site");
	}
	public void hoverOnSignin() {
		Actions action= new Actions(driver);
		action.moveToElement(helloSignIn).build().perform();
	}
	public SigninEmailMobile clickOnSignin() {
		signIn.click();
		return new SigninEmailMobile(driver);
	}
	

}
