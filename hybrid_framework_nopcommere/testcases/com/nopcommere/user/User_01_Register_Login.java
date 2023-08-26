package com.nopcommere.user;

import org.testng.annotations.Test;

import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

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

public class User_01_Register_Login extends BasePage {
	WebDriver driver;
//	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
//		basePage = BasePage.getBasePageObject();
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "w_firstname");
		sendkeyToElement(driver, "//input[@id='LastName']", "w_lastname");
		sendkeyToElement(driver, "//input[@id='Password']", "ccc@@aa");
		sendkeyToElement(driver, "//input[@id='Email']", "Abc123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc123456");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "w_firstname");
		sendkeyToElement(driver, "//input[@id='LastName']", "w_lastname");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "Abc123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc123456");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "w_firstname");
		sendkeyToElement(driver, "//input[@id='LastName']", "w_lastname");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "Abc123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc123456");

		clickToElement(driver, "//button[@id='register-button']");
		assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"),
				"The specified email already exists");

	}

	@Test
	public void TC_05_Password_Less_Than_6_Chars() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "w_firstname");
		sendkeyToElement(driver, "//input[@id='LastName']", "w_lastname");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "12");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12");

		clickToElement(driver, "//button[@id='register-button']");
		assertEquals(getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "w_firstname");
		sendkeyToElement(driver, "//input[@id='LastName']", "w_lastname");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "Abc123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc111456");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");

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
