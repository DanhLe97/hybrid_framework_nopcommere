package pageObject.NopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopcommerceUser.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	public RegisterPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);
	}



	public String getErrorMessageFirstNameTextBox() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}



	public String getErrorMessageLastNameTextBox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}



	public String getErrorMessageEmailTextBox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}



	public String getErrorMessageConfirmPasswordTextBox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE); 
		getElementText(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
	}



	public String getErrorMessagePasswordTextBox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}



	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}



	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}



	public void inputToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}



	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}



	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);
		
	}



	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_SUCCESS_MESSAGE);
		getElementText(driver, RegisterPageUI.REGISTRATION_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTRATION_SUCCESS_MESSAGE);
	}



	public String getExistingEmailErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTINGEMAIL_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.EXISTINGEMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXISTINGEMAIL_ERROR_MESSAGE);
	}



	public String getMoreThan6CharactersMessage() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}



	public String getInvalidConfirmPasswordMessage() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
	}


//
//	public UserHomePageObject clickToLogOutButton() {
//		waitForElementClickable(driver, RegisterPageUI.LOGOUT_BUTTON);
//		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
//		return PageGeneratorManager.getHomePage(driver);
//	}




}
