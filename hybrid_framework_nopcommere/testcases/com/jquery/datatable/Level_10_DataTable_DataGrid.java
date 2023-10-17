package com.jquery.datatable;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.JQuery.HomePageObject;
import pageObject.Nopcommerce.PageGeneratorManager;
import pageObject.Nopcommerce.UserAddressPageObject;
import pageObject.Nopcommerce.UserCustomerInforPageObject;
import pageObject.Nopcommerce.UserMyProductReviewPageObject;
import pageObject.Nopcommerce.UserRewardPointsPageObject;
import pageObject.NopcommerceAdmin.AddressPageObject;
import pageObject.NopcommerceAdmin.AdminDashBoardPageObject;
import pageObject.NopcommerceAdmin.AdminLoginPageObject;

@Test
public class Level_10_DataTable_DataGrid extends BaseTest {
HomePageObject homePage;
	@org.testng.annotations.Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = pageObject.JQuery.PageGeneratorManager.getHomePageObject(driver);
	}

//	public void TC_01_User_To_Admin() {
//		
//	}

	public void Table_01() {
		homePage.openPagingByPageNumber("2");
		assertTrue(homePage.isPaginationSelected("2"));
		homePage.openPagingByPageNumber("4");
		assertTrue(homePage.isPaginationSelected("4"));
		homePage.openPagingByPageNumber("5");
		assertTrue(homePage.isPaginationSelected("5"));
		homePage.openPagingByPageNumber("7");
		assertTrue(homePage.isPaginationSelected("7"));
		homePage.refreshCurrentPage(driver);
		
		}
	

	public void Table_02_Enter_To_Header() {
		homePage.enterToHeaderTextboxByLabel("Females","777");
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country","Angola");
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Males","25266");
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Total","1580");
		homePage.refreshCurrentPage(driver);

	}

	public void Table_03() {

	}

	public void Table_04() {

	}

	public void Table_05() {

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
	
}
