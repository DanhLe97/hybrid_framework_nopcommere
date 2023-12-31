package pageObject.railway;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.railway.EmailPageUI;

public class EmailPageObject extends BasePage {
	WebDriver driver;

	public EmailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject verifyRegistedAccount(String emailName, String emailDomain) {
		waitForElementClickable(driver, EmailPageUI.CLICK_TO_EDIT_LABEL);
		selectItemInDefaultDropdown(driver, EmailPageUI.EMAIL_DOMAIN_DROPDOWN, emailDomain);
		clickToElement(driver, EmailPageUI.CLICK_TO_EDIT_LABEL);
		sendkeyToElement(driver, EmailPageUI.TEXTBOX_EMAILNAME, emailName);
		clickToElement(driver, EmailPageUI.BUTTON_BY_NAME, "Set");
		sleepInSecond(10);
		clickToElement(driver, EmailPageUI.RECIEVED_EMAIL, "Please confirm your account");
		clickToElement(driver, EmailPageUI.ACTIVATE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
//		    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		    driver.switchTo().window(tabs.get(0));
//		    driver.close();
		    
	}

	public LoginPageObject resetAccountPassword(String emailName, String emailDomain) {
		waitForElementClickable(driver, EmailPageUI.CLICK_TO_EDIT_LABEL);
		selectItemInDefaultDropdown(driver, EmailPageUI.EMAIL_DOMAIN_DROPDOWN, emailDomain);
		clickToElement(driver, EmailPageUI.CLICK_TO_EDIT_LABEL);
		sendkeyToElement(driver, EmailPageUI.TEXTBOX_EMAILNAME, emailName);
		clickToElement(driver, EmailPageUI.BUTTON_BY_NAME, "Set");
		sleepInSecond(10);
		clickToElement(driver, EmailPageUI.RECIEVED_EMAIL, "Please reset your password");
		clickToElement(driver, EmailPageUI.ACTIVATE_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
