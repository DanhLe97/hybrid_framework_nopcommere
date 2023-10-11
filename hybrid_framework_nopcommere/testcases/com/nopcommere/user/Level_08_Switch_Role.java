package com.nopcommere.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.Nopcommerce.HomePageObject;

@Test
public class Level_08_Switch_Role extends BaseTest {
	WebDriver driver;
//	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	private String firstName;
	private String lastName;
	private String password;
	private String validEmailAddress;
	private String notFoundEmailAddress;
	private HomePageObject homePage;

	@org.testng.annotations.Parameters("browser")
	@BeforeClass
		public void beforeClass(String browserName) {
			driver = getBrowserDriver(browserName);
//			basePage = BasePage.getBasePageObject();
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


	public void TC_01_Register_Empty_Data() {
	}

	public void TC_02_Register_Invalid_Email() {

	}

	public void TC_03_Register_Success() {

	}

	public void TC_04_Register_Existing_Email() {

	}

	public void TC_05_Password_Less_Than_6_Chars() {

	}

	public void TC_06_Register_Invalid_Confirm_Password() {

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
