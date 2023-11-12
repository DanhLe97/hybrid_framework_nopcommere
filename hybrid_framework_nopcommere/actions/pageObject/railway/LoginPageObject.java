package pageObject.railway;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.railway.BasePageUI;
import pageUIs.railway.BookTicketPageUI;
import pageUIs.railway.LoginPageUI;
import pageUIs.railway.RegisterPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject login(String email, String password) {
		scrollToElement(driver, LoginPageUI.TEXTBOX_BY_NAME, "username");
		scrollToElement(driver, LoginPageUI.TEXTBOX_BY_NAME, "password");
		sendkeyToElement(driver, LoginPageUI.TEXTBOX_BY_NAME, email, "username");
		sendkeyToElement(driver, LoginPageUI.TEXTBOX_BY_NAME, password, "password");
		scrollToElement(driver, LoginPageUI.BUTTON_BY_TEXT, "login");
		clickToElement(driver, LoginPageUI.BUTTON_BY_TEXT, "login");
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getTextboxValidation(String labelName) {
		scrollToElement(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);
		getElementText(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);
		return getElementText(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);

	}

	public String getHeaderValidation() {
		waitForElementVisible(driver, LoginPageUI.HEADER_VALIDTION);
		getElementText(driver, LoginPageUI.HEADER_VALIDTION);
		return getElementText(driver, LoginPageUI.HEADER_VALIDTION);

	}

	public boolean isLoginButtonStillVisible() {
		scrollToElement(driver, LoginPageUI.BUTTON_BY_TEXT, "login");
		clickToElement(driver, LoginPageUI.BUTTON_BY_TEXT, "login");
		return true;
	}

	public void clickToLink(String textName) {
		waitForElementClickable(driver, LoginPageUI.LINK_BY_TEXT, textName);
		clickToElement(driver, LoginPageUI.LINK_BY_TEXT, textName);

	}

	public void sendResetPasswordRequest(String email) {
		waitForElementVisible(driver, LoginPageUI.TEXTBOX_BY_NAME, "email");
		sendkeyToElement(driver, LoginPageUI.TEXTBOX_BY_NAME, email, "email");
		clickToElement(driver, LoginPageUI.BUTTON_BY_TEXT, "Send Instructions");
	}
	public boolean isFormDisplayed () {
		waitForElementVisible(driver, LoginPageUI.FORM_TITLE);
		isElementDisplayed(driver, LoginPageUI.FORM_TITLE);
		return true;
	}
	public void setNewPassword(String newPassword, String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.TEXTBOX_BY_NAME, "newPassword");
		sendkeyToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, newPassword, "newPassword");

		scrollToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, "confirmPassword");
		sendkeyToElement(driver, RegisterPageUI.TEXTBOX_BY_NAME, confirmPassword, "confirmPassword");
		scrollToElement(driver, RegisterPageUI.BUTTON_BY_TEXT, "Reset Password");
		clickToElement(driver, RegisterPageUI.BUTTON_BY_TEXT, "Reset Password");

	}
	public boolean isResetTokenDisplayed() {
	    Boolean result = false;
	    try {
	        String value = getElementAttribute(driver, LoginPageUI.TEXTBOX_BY_NAME, "value", "resetToken");
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return result;
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

	public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "Date");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, ticketAmount, "Date");
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "DepartStation");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, ticketAmount, "DepartStation");
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "ArriveStation");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, ticketAmount, "ArriveStation");
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "SeatType");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, ticketAmount, "SeatType");
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "TicketAmount");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, ticketAmount, "TicketAmount");
		scrollToElement(driver, BookTicketPageUI.BUTTON_BOOKTICKET);
		clickToElement(driver, BookTicketPageUI.BUTTON_BOOKTICKET);
	}
	}
