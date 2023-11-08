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

	public HomePageObject clickToMenuItem(String itemName) {
		waitForElementClickable(driver, BasePageUI.MENU_ITEM_BY_NAME, itemName);
		clickToElement(driver, BasePageUI.MENU_ITEM_BY_NAME, itemName);
		return PageGeneratorManager.getHomePage(driver);
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
		
		scrollToElement(driver, RegisterPageUI.BUTTON_REGISTER);
		clickToElement(driver, RegisterPageUI.BUTTON_REGISTER);
	}

	public String getTextboxValidation(String labelName) {
		scrollToElement(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);
//		waitForElementVisible(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);
		getElementText(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);
		return getElementText(driver, RegisterPageUI.VALIDATION_MESSAGE_BY_LABEL_NAME, labelName);
		
	}
}
