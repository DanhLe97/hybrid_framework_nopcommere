package pageObject.liveGuru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.AdminCustomersPageUI;

public class AdminCustomersPageObject extends BasePage {
	public WebDriver driver;
	public AdminCustomersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterValueToTextboxByColumName(String columnName, String email) {
		waitForElementVisible(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_NAME, columnName);
		int columnIndex = getElementSize(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		sendkeyToElement(driver, AdminCustomersPageUI.TEXTBOX_BY_COMLUN_INDEX, email, String.valueOf(columnIndex));
		pressKeyToElement(driver, AdminCustomersPageUI.TEXTBOX_BY_COMLUN_INDEX, Keys.ENTER,
				String.valueOf(columnIndex));
	}

	public String getSearchResultByColumnName(String columnName) {
		waitForElementVisible(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_NAME, columnName);
		int columnIndex = getElementSize(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
	sleepInSecond(3);
		getElementText(driver, AdminCustomersPageUI.SEARCH_RESULT_BY_COLUMN_INDEX, String.valueOf(columnIndex));
		return getElementText(driver, AdminCustomersPageUI.SEARCH_RESULT_BY_COLUMN_INDEX, String.valueOf(columnIndex));

	}

	public void selectAction(String action, String button) {
		waitForElementClickable(driver, AdminCustomersPageUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCustomersPageUI.ACTION_DROPDOWN, action);
		clickToElement(driver, AdminCustomersPageUI.BUTTON_BY_NAME, button);
		acceptAlert(driver);
		getAlerText(driver);
		
	}

	public void selectSearchResult() {
		waitForElementClickable(driver, AdminCustomersPageUI.SEARCH_RESULT_CHECKBOX);
		clickToElement(driver, AdminCustomersPageUI.SEARCH_RESULT_CHECKBOX);
	}

}