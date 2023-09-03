package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox () {}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputIntoEmailTextbox(String validEmailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX	, validEmailAddress);		
	}

	public void inputIntoPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

//	public String getErrorMessageAtPasswordTextbox() {
//		waitForElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
//		getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
//		return getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
//	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, LoginPageUI.VALIDATION_ERROR_MESSAGE);
		getElementText(driver, LoginPageUI.VALIDATION_ERROR_MESSAGE);
		return 	getElementText(driver, LoginPageUI.VALIDATION_ERROR_MESSAGE);
 
	}

	public void clickToLoginLink() {
		clickToElement(driver, LoginPageUI.LOGIN_LINK);
	}


	
}
