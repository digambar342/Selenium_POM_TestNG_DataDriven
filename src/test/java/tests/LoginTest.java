package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AmazonHomePage;
import pages.ForgotPassword;
import pages.SigninEmailMobile;
import pages.SigninPassword;
import utils.Utilities;

public class LoginTest extends BaseTest{
	AmazonHomePage amazonHomePage;
	SigninEmailMobile signinEmailMobile;
	SigninPassword signinPassword;
	ForgotPassword forgotPassword;
	
	@Test(retryAnalyzer = analyzer.RetryAnalyzer.class)
	public void loginAndForgotPassword() throws IOException {
		amazonHomePage = new AmazonHomePage(driver);
		Assert.assertTrue(amazonHomePage.verifyTitle());
		amazonHomePage.hoverOnSignin();
		signinEmailMobile = amazonHomePage.clickOnSignin();
		signinEmailMobile.verifyPageTitle();
		signinEmailMobile.inputPhone(Utilities.getDataFromExcelSheet("sheet1", "PhoneNumber", "Digambar"));
		signinPassword = signinEmailMobile.clickContinue();
		signinPassword.inputPassword(Utilities.getDataFromExcelSheet("sheet1", "Password", "Digambar"));
		signinPassword.clickOnForgotPasswordLink();
		Assert.assertTrue(signinPassword.verifyForgotPasswordTitle());
		System.out.println("Inside failed TC");
		Assert.assertFalse(signinPassword.verifySigninTitle());
	}
	@Test
	public void method2() throws IOException {
		System.out.println("inside method 2");
		System.out.println("edited from Git");
		
	}
	@Test
	public void method3() throws IOException {
		System.out.println("inside method 3");
		System.out.println("inside method 3.1");
	}

}
