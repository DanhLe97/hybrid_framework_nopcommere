package com.somee.railway;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import commons.BaseTest;
import pageObject.railway.EmailPageObject;
import pageObject.railway.HomePageObject;
import pageObject.railway.LoginPageObject;
import pageObject.railway.PageGeneratorManager;
import pageObject.railway.RegisterPageObject;

public class ResetPassword extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	EmailPageObject emailPage;

	private String emailName = getDateTimeRandom();
	private String emailDomain = "pokemail.net";
	private String password = getDateTimeRandom();
	private String pidNumber = "123456789";
	private String email = emailName + "@" + emailDomain;
	private String newPassword = password + "2";

	@org.testng.annotations.Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(@Optional("firefox") String browserName,
			@Optional("http://saferailway.somee.com/Page/HomePage.cshtml") String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Create_And_Active_Account();
		System.out.println(email);
		System.out.println(password);
	}
	
	@Test
	public void TC_11_Reset_Password_Shows_Error_If_New_Password_And_Confirmpassword_Do_Not_Match() {
		loginPage = (LoginPageObject) homePage.clickToMenuItem("Login");
		loginPage.clickToLink("Forgot Password");
		loginPage.sendResetPasswordRequest(email);
		loginPage.openPageUrl(driver, "https://www.guerrillamail.com/inbox");
		emailPage = PageGeneratorManager.getEmailPage(driver);
		loginPage = emailPage.resetAccountPassword(emailName, emailDomain);
		closeTab();
		switchToLatestTab();
		loginPage.setNewPassword(newPassword, "111111111");
		assertEquals("The password confirmation did not match the new password.",
				loginPage.getTextboxValidation("confirmPassword"));
		assertEquals("Could not reset password. Please correct the errors and try again.",
				loginPage.getHeaderValidation());
//		registerPage.clickToMenuItem("Home");
	}
	
	@Test
	public void TC_10_Reset_Password_Shows_Error_If_New_Password_Same_As_Current() {
		loginPage = (LoginPageObject) homePage.clickToMenuItem("Login");
		loginPage.clickToLink("Forgot Password");
		loginPage.sendResetPasswordRequest(email);
		loginPage.openPageUrl(driver, "https://www.guerrillamail.com/inbox");
		emailPage = PageGeneratorManager.getEmailPage(driver);
		loginPage = emailPage.resetAccountPassword(emailName, emailDomain);
		closeTab();
		switchToLatestTab();
		assertTrue(loginPage.isFormDisplayed());
		assertTrue(loginPage.isResetTokenDisplayed());
		loginPage.setNewPassword(password, password);
		assertEquals("The new password cannot be the same with the current password", registerPage.getHeaderMessage());
		homePage=(HomePageObject) loginPage.clickToMenuItem("Home");
	}
	
	public void Create_And_Active_Account() {
		registerPage = (RegisterPageObject) homePage.clickToMenuItem("Register");
		registerPage.registNewAccount(email, password, pidNumber);
		registerPage.openPageUrl(driver, "https://www.guerrillamail.com/inbox");
		emailPage = PageGeneratorManager.getEmailPage(driver);
		registerPage = emailPage.verifyRegistedAccount(emailName, emailDomain);
		closeTab();
		switchToLatestTab();
		registerPage.clickToMenuItem("Home");

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();

	}
}
