package com.somee.railway;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.railway.EmailPageObject;
import pageObject.railway.HomePageObject;
import pageObject.railway.LoginPageObject;
import pageObject.railway.PageGeneratorManager;
import pageObject.railway.RegisterPageObject;

public class CreateAccount extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	EmailPageObject emailPage;

	private String emailName = getDateTimeRandom();
	private String emailDomain = "pokemail.net";
	private String password = getDateTimeRandom();
	private String pidNumber = "123456789";
	@org.testng.annotations.Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	@Test
	public void TC_08_User_Cant_Create_Account_With_Empty_PID_And_Password () {
		registerPage = homePage.clickToMenuItem("Register");
		
		registerPage.registNewAccount(emailName+"@"+emailDomain, "","");
		assertEquals(registerPage.getTextboxValidation("password"), "Invalid password length");
		assertEquals(registerPage.getTextboxValidation("pid"), "Invalid ID length");
		homePage=registerPage.clickToMenuItem("Home");
	
	}
	@Test
	public void TC_09_User_Create_And_Active_Acconut() {
		registerPage = homePage.clickToMenuItem("Register");
		registerPage.registNewAccount(emailName+"@"+emailDomain, password,pidNumber);
		registerPage.openPageUrl(driver, "https://www.guerrillamail.com/inbox");
		emailPage = PageGeneratorManager.getEmailPage(driver);
		emailPage.verifyRegistedAccount(emailName,emailDomain);
		
	}
	@Test
	public void User_Cant_Create_Account_With_An_Already_Inuse_Email() {
		home
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();

	}
	}
