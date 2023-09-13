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
import pageObject.Nopcommerce.CustomerPageObject;
import pageObject.Nopcommerce.HomePageObject;
import pageObject.Nopcommerce.LoginPageObject;
import pageObject.Nopcommerce.RegisterPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
//	BasePage basePage;
	private String validEmailAddress;
	private String notFoundEmailAddress;
	private HomePageObject homePage;
	private String firstName;
	private String lastName;
	private String password;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	@org.testng.annotations.Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
//		basePage = BasePage.getBasePageObject();
		firstName = "w_firstName";
		lastName = "w_lastName";
		password = "123456";
		validEmailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		notFoundEmailAddress = "afc" + generateFakeNumber() + "@email.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
		homePage = new HomePageObject(driver);

		

		
		
	}

	@Test
	public void User_01_Register() {

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(validEmailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();
		assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	
		homePage = registerPage.clickToLogOutButton();

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputIntoEmailTextbox(validEmailAddress);
		loginPage.inputIntoPasswordTextbox(password);
		homePage= loginPage.clickToLoginButton(); 
		
		assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void User_03_My_Account() {
		customerPage = homePage.clickToMyAccountLink();
		
	} 
	@Test
	public void User_04_Switch_Page() {
	}

	@Test
	public void User_05_Switch_Role() {
	}

	@Test
	public void Login_06_Existing_Email_Correct_Password() {
		loginPage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputIntoEmailTextbox(validEmailAddress);
		loginPage.inputIntoPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
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
