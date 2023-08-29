package com.nopcommere.user;

import org.testng.annotations.Test;

import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;
import pageUIs.RegisterPageUI;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object extends BasePage {
	private WebDriver driver;
//	BasePage basePage;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName;
	private String lastName;
	private String password;
	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
//		basePage = BasePage.getBasePageObject();
		firstName = "w_firstName";
		lastName = "w_lastName";
		password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		System.out.println("Step 01: Click to register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Step 03: Verify error messages");
		assertEquals(registerPage.getErrorMessageFirstNameTextBox(),"First name is required.");
		assertEquals(registerPage.getErrorMessageLastNameTextBox(),"Last name is required.");
		assertEquals(registerPage.getErrorMessageEmailTextBox(),"Email is required.");
		assertEquals(registerPage.getErrorMessagePasswordTextBox(),"Password is required.");
		assertEquals(registerPage.getErrorMessageConfirmPasswordTextBox(),"Password is required.");


		
		
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		System.out.println("Step 01: Click to register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Step 02: Input into required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("123@@321");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		
		System.out.println("Step 03: Verify email error message");
		registerPage.clickToRegisterButton();
		assertEquals(registerPage.getErrorMessageEmailTextBox(),"Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		System.out.println("Step 01: Click to register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Step 02: Input into required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		
		System.out.println("Step 03: Click on register button");
		registerPage.clickToRegisterButton();

		System.out.println("Step 04: Verify success message");
		assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
//		System.out.println("Click on the log out button");
//		registerPage.clickToLogOutButton();
		
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_BUTTON);
		registerPage.clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
		System.out.println("Step 01: Click to register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Step 02: Input into required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		
		System.out.println("Step 03: Click on register button");
		registerPage.clickToRegisterButton();

		System.out.println("Step 04: Verify existing error message");
		assertEquals(registerPage.getExistingEmailErrorMessage(),"The specified email already exists");
	}

	@Test
	public void TC_05_Password_Less_Than_6_Chars() {
		System.out.println("Step 01: Click to register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Step 02: Input into required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("123");
		registerPage.inputToConfirmPasswordTextBox("123");
		
		
		System.out.println("Step 03: Click on register button");
		registerPage.clickToRegisterButton();

		System.out.println("Step 04: Verify more than 6 characters message");
		assertEquals(registerPage.getMoreThan6CharactersMessage(),"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		System.out.println("Step 01: Click to register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Step 02: Input into required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox("7777777");
		
		
		System.out.println("Step 03: Click on register button");
		registerPage.clickToRegisterButton();

		System.out.println("Step 04: Verify existing error message");
		assertEquals(registerPage.getInvalidConfirmPasswordMessage(),"The password and confirmation password do not match.");
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
