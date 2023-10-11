package com.nopcommere.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.Nopcommerce.UserHomePageObject;
import pageObject.Nopcommerce.LoginPageObject;
import pageObject.Nopcommerce.PageGeneratorManager;
import pageObject.Nopcommerce.UserRegisterPageObject;

public class Level_06_Page_Generator_III extends BaseTest {
	private WebDriver driver;
//	BasePage basePage;
	private String validEmailAddress;
	private String notFoundEmailAddress;
	private UserHomePageObject homePage;
	private String firstName;
	private String lastName;
	private String password;
	private UserRegisterPageObject registerPage;
	private LoginPageObject loginPage;
	@org.testng.annotations.Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver); 
		firstName = "w_firstName";
		lastName = "w_lastName";
		password = "123456";
		validEmailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		notFoundEmailAddress = "afc" + generateFakeNumber() + "@email.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
	

		

		
		
		System.out.println("Precondition - Step 01: Click to register link");
		homePage.clickToRegisterLink();
		
		registerPage = PageGeneratorManager.getUserRegisterPage(driver);
		System.out.println("Precondition - Step 02: Input into required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(validEmailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		
		System.out.println("Precondition - Step 03: Click on register button");
		registerPage.clickToRegisterButton();

		System.out.println("Precondition - Step 04: Verify success message");
		assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	
		System.out.println("Precondition - Step 05: Click on log out button");
//		registerPage.clickToLogOutButton();
		homePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.clickToLoginLink();
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		loginPage.inputIntoEmailTextbox("123@");
		loginPage.inputIntoPasswordTextbox(password);
		loginPage.clickToLoginButton(); 
		
		assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		loginPage.clickToLoginLink();
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		loginPage.inputIntoEmailTextbox(notFoundEmailAddress);
		loginPage.inputIntoPasswordTextbox(password);
		loginPage.clickToLoginButton(); 
		
		assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage.clickToLoginLink();
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		loginPage.inputIntoEmailTextbox(validEmailAddress);
		loginPage.inputIntoPasswordTextbox("");
		loginPage.clickToLoginButton();
		
		assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Wrong_Password() {
		loginPage.clickToLoginLink();
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		loginPage.inputIntoEmailTextbox(validEmailAddress);
		loginPage.inputIntoPasswordTextbox("111111");
		loginPage.clickToLoginButton();
		
	assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Existing_Email_Correct_Password() {
		loginPage.clickToLoginLink();
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		loginPage.inputIntoEmailTextbox(validEmailAddress);
		loginPage.inputIntoPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		assertTrue(homePage.isMyAccountLinkIsDisplayed());
		
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
