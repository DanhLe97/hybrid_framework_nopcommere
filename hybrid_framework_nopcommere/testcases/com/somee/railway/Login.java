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

import commons.BaseTest;
import pageObject.railway.EmailPageObject;
import pageObject.railway.HomePageObject;
import pageObject.railway.LoginPageObject;
import pageObject.railway.PageGeneratorManager;
import pageObject.railway.RegisterPageObject;

public class Login extends BaseTest {
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
	public void TC_01_User_Login_With_Valid_Username_And_Password() {
		loginPage = (LoginPageObject) homePage.clickToMenuItem("Login");
		loginPage.login(email, password);
		assertEquals("Welcome " + email, homePage.getWelcomeMessage());

		homePage.clickToMenuItem("Log out");
	}

	@Test
	public void TC_02_User_Cant_Login_With_Blank_Username() {
		loginPage = (LoginPageObject) homePage.clickToMenuItem("Login");
		loginPage.login("", password);
		assertEquals("There was a problem with your login and/or errors exist in your form.",
				loginPage.getHeaderValidation());
		assertTrue(loginPage.isLoginButtonStillVisible());
	}

	@Test
	public void TC_03_User_Cant_Login_With_Invalid_Password() {
		loginPage = (LoginPageObject) homePage.clickToMenuItem("Login");
		loginPage.login(email, "99999999");
		assertEquals("There was a problem with your login and/or errors exist in your form.",
				loginPage.getHeaderValidation());
	}

	@Test
	public void TC_03_System_Show_Message_After_Login_With_Wrong_Password_Many_Times() {
		loginPage = (LoginPageObject) homePage.clickToMenuItem("Login");
		repeatLogin(4);

		assertEquals("Invalid username or password. Please try again.", loginPage.getHeaderValidation());
	}

	@Test
	public void TC_04_User_Cant_Login_With_Inactive_Account() {
		Create_Account();
		loginPage = (LoginPageObject) registerPage.clickToMenuItem("Login");
		loginPage.login(emailName + "n@" + emailDomain, password);
		assertEquals("Invalid username or password. Please try again.", loginPage.getHeaderValidation());

	}

	public void repeatLogin(int t) {
		for (int i = 0; i < t; i++) {
			loginPage.login(email, "999999999");
		}
	}

	public void Create_Account() {
		registerPage = (RegisterPageObject) homePage.clickToMenuItem("Register");
		registerPage.registNewAccount(emailName + "n@" + emailDomain, password, pidNumber);
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

	@Test
	public void User_Cant_Create_Account_With_An_Already_Inuse_Email() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();

	}
}
