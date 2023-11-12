package pageObject.railway;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.railway.BasePageUI;
import pageUIs.railway.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
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
		default:
			throw new IllegalArgumentException("Unexpected value: " + itemName);
		}
	}

	public void registNewAccount(String email, String password, String pidNumber) {
		waitForElementVisible(driver, RegisterPageUI.TEXTBOX_BY_NAME, "email");
		sendkeyToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, email, "email");

		waitForElementVisible(driver, RegisterPageUI.TEXTBOX_BY_NAME, "password");
		sendkeyToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, password, "password");

		scrollToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, "confirmPassword");
		sendkeyToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, password, "confirmPassword");

		scrollToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, "pid");
		sendkeyToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, pidNumber, "pid");

		scrollToElement(driver, RegisterPageUI.BUTTON_BY_TEXT, "Register");
		clickToElement(driver, RegisterPageUI.BUTTON_BY_TEXT, "Register");

	}

	public String getTextboxValidation(String labelName) {
		scrollToElement(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);
		getElementText(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);
		return getElementText(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);

	}

	public String getHeaderMessage() {
		waitForElementVisible(driver, RegisterPageUI.HEADER_MESSAGE);
		getElementText(driver, RegisterPageUI.HEADER_MESSAGE);
		return getElementText(driver, RegisterPageUI.HEADER_MESSAGE);
	}

	
}
