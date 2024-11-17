package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	private WebDriver driver;

	public ForgotPassword(WebDriver driver) {
		driver=this.driver;
		PageFactory.initElements(driver, this);
	}
	public boolean verifyTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle().contains("Password Assistance");
	}
}
