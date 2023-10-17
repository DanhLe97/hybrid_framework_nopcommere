package pageObject.JQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

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
}
