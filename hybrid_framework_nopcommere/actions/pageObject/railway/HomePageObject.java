package pageObject.railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.railway.BasePageUI;
import pageUIs.railway.HomePageUI;
import pageUIs.railway.RegisterPageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object clickToMenuItem(String itemName) {
		waitForElementClickable(driver, BasePageUI.MENU_ITEM_BY_NAME, itemName);
		clickToElement(driver, BasePageUI.MENU_ITEM_BY_NAME, itemName);
		switch (itemName) {
		case "Home":

			return PageGeneratorManager.getHomePage(driver);
		case "Register":
			return PageGeneratorManager.getRegisterPage(driver);
		case "Book ticket":
			return PageGeneratorManager.getBookTicketPage(driver);
		case "Timetable":
			return PageGeneratorManager.getTimetablePage(driver);
		case "Ticketprice":
			return PageGeneratorManager.getTicketpricePage(driver);
		case "Log out":
			return PageGeneratorManager.getHomePage(driver);
		case "Login":
			return PageGeneratorManager.getLoginPage(driver);
		case "FAQ":
			return PageGeneratorManager.getFAQPage(driver);
		default:
			throw new IllegalArgumentException("Unexpected value: " + itemName);
		}
	}

	public String getWelcomeMessage() {
		waitForAllElementsVisible(driver, HomePageUI.MSG_WELCOME);
		getElementText(driver, HomePageUI.MSG_WELCOME);
		return getElementText(driver, HomePageUI.MSG_WELCOME);
	}

	public boolean isPageDisplayed(String itemName) {
		waitForElementVisible(driver, BasePageUI.MENU_ITEM_BY_NAME,itemName);
		isElementSelected(driver, BasePageUI.MENU_ITEM_BY_NAME,itemName);
		System.out.println(itemName+" is displayed");
		return true;
	}


	}
