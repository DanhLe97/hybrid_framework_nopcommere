package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}



	public String getErrorMessageFirstNameTextBox() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return null;
	}



	public String getErrorMessageLastNameTextBox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return null;
	}



	public String getErrorMessageEmailTextBox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return null;
	}



	public String getErrorMessageConfirmPasswordTextBox() {
		getElementText(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
		return null;
	}



	public String getErrorMessagePasswordTextBox() {
		getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return null;
	}



	public void inputToFirstNameTextBox(String firstName) {
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}



	public void inputToLastNameTextBox(String string) {
		// TODO Auto-generated method stub
		
	}



	public void inputToEmailTextBox(String string) {
		// TODO Auto-generated method stub
		
	}



	public void inputToPasswordTextBox(String string) {
		// TODO Auto-generated method stub
		
	}



	public void inputToConfirmPasswordTextBox(String string) {
		// TODO Auto-generated method stub
		
	}



	public String getRegisterSuccessMessage() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getExistingEmailErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getMoreThan6CharactersMessage() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getInvalidConfirmPasswordMessage() {
		// TODO Auto-generated method stub
		return null;
	}




}
