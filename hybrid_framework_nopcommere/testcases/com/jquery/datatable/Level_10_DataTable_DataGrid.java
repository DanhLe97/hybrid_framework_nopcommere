package com.jquery.datatable;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.JQuery.HomePageObject;
@Test
public class Level_10_DataTable_DataGrid extends BaseTest {
HomePageObject homePage;
List<String> actualAllCountryValues;
List<String> expectedAllCountryValues;

	@org.testng.annotations.Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = pageObject.JQuery.PageGeneratorManager.getHomePageObject(driver);
	}

//	public void TC_01_User_To_Admin() {
//		
//	}

//	public void Table_01() {
//		homePage.openPagingByPageNumber("2");
//		assertTrue(homePage.isPaginationSelected("2"));
//		homePage.openPagingByPageNumber("4");
//		assertTrue(homePage.isPaginationSelected("4"));
//		homePage.openPagingByPageNumber("5");
//		assertTrue(homePage.isPaginationSelected("5"));
//		homePage.openPagingByPageNumber("7");
//		assertTrue(homePage.isPaginationSelected("7"));
//		homePage.refreshCurrentPage(driver);
//		
//		}
//	
//
//	public void Table_02_Enter_To_Header() {
//		homePage.enterToHeaderTextboxByLabel("Females","777");
//		homePage.refreshCurrentPage(driver);
//
//		homePage.enterToHeaderTextboxByLabel("Country","Angola");
//		homePage.refreshCurrentPage(driver);
//
//		homePage.enterToHeaderTextboxByLabel("Males","25266");
//		homePage.refreshCurrentPage(driver);
//
//		homePage.enterToHeaderTextboxByLabel("Total","1580");
//		homePage.refreshCurrentPage(driver);
//
//	}

//	public void Table_03_Data_Table() {
//		//Đọc dữ liệu của file country.txt ra
//		// Lưu vào 1 List<String> = Expected value = expectedAllCountryValues
//		
//		//Actual value
//		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
//		assertEquals(actualAllCountryValues, expectedAllCountryValues);
//	}
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickOnLoadBtn();
		homePage.enterToTextboxAtRowNumberByColumnName("Company","1","Kiehn DeckHow");
		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person","1","HistoName");
		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed","1","123");
		homePage.selectDropdownByColumnNameAtRowNumber("Country","1","Germany");
		homePage.selectDropdownByColumnNameAtRowNumber("Country","3","Japan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country","5","Taiwan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country","7","Japan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country","8","Malaysia");
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("columnName","rowNumber");
	}

	public void Table_05() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();

	}

	WebDriver driver;
	
}