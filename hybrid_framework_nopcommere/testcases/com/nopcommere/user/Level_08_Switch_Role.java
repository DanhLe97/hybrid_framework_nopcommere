package com.nopcommere.user;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.Nopcommerce.PageGeneratorManager;
import pageObject.NopcommerceAdmin.AdminDashBoardPageObject;
import pageObject.NopcommerceAdmin.AdminLoginPageObject;

@Test
public class Level_08_Switch_Role extends BaseTest {

	@org.testng.annotations.Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
//			basePage = BasePage.getBasePageObject();
		firstName = "w_firstName";
		lastName = "w_lastName";
		userPassword = "123456";
		userEmail = "w_test1@testing.com";
		
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
		
		notFoundEmailAddress = "afc" + generateFakeNumber() + "@email.com";

	}

	public void TC_01_User_To_Admin() {
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.loginAsUser(userEmail, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkIsDisplayed());
		userHomePage.logoutUserPage(driver);
		
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashBoardPage = adminLoginPage.login(adminEmail, adminPassword);
		assertTrue(adminDashBoardPage.isDashBoardPageDisplayed());
		adminDashBoardPage.logoutAdminPage(driver);
		
	}

	public void TC_02_Admin_To_User() {
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashBoardPage = adminLoginPage.login(adminEmail, adminPassword);
		assertTrue(adminDashBoardPage.isDashBoardPageDisplayed());
		adminDashBoardPage.logoutAdminPage(driver);
		
		userHomePage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.loginAsUser(userEmail, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkIsDisplayed());
		userHomePage.logoutUserPage(driver);
		
		
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

	WebDriver driver;
//	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	private String firstName;
	private String lastName;
	private String userPassword;
	private String userEmail;
	private String adminPassword;
	private String adminEmail;
	private String notFoundEmailAddress;
	private pageObject.Nopcommerce.UserHomePageObject userHomePage;
	private pageObject.Nopcommerce.LoginPageObject userLoginPage;
	private AdminDashBoardPageObject adminDashBoardPage;
	private AdminLoginPageObject adminLoginPage;
}
