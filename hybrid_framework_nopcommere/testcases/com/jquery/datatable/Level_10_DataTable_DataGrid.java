package com.jquery.datatable;

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
		homePage.openPagingByPageNumber("4");
		homePage.openPagingByPageNumber("5");
		homePage.openPagingByPageNumber("7");
		
		}
	

	public void Table_02() {

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
