package pageObject.JQuery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.JQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForAllElementsVisible(driver, HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);

	}

	public void enterToHeaderTextboxByLabel(String labelName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, labelName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, labelName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, labelName);
	}

	public boolean isPaginationSelected(String pageNumber) {
		waitForAllElementsVisible(driver, HomePageUI.DISPLAYED_PAGE_BY_NUMBER, pageNumber);
		isElementDisplayed(driver, HomePageUI.DISPLAYED_PAGE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.DISPLAYED_PAGE_BY_NUMBER, pageNumber);

	}

	public List getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size: " + totalPage);
		List<String> allRowValueAllPage = new ArrayList<String>();
		Set<String> allRowValueUniqueAllPage = new HashSet<>();
		// Duyệt qua tất cả các page number (paging)
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_BY_INDEX, String.valueOf(index));

			// Get text của all row each page đưa vào array list
			List<WebElement> allRowElementEachPage = getListWebElements(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		for (String value : allRowValueAllPage) {
//				System.out.println("----------------------------------");
			System.out.println(value);
		}

		return allRowValueAllPage;
	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String value) {
		waitForElementVisible(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName);
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
//		// send key vào dòng
		waitForElementClickable(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,
				String.valueOf(columnIndex));
		
	}

//	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String value) {
//		// get column index dựa vào tên cột
//		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
//		// send key vào dòng
//		waitForAllElementsVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
//				String.valueOf(columnIndex));
//		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,
//				String.valueOf(columnIndex));

	}

