package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;
import pageUIs.liveGuru.LoginPageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountLink() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_OPTION);
		clickToElement(driver, HomePageUI.LOGIN_OPTION);
		return new PageGeneratorManager().getLoginPageObject(driver);
	}
	public MyAccountPageObject login(String email, String password) {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.LOGIN_OPTION);
		sendkeyToElement(driver, LoginPageUI.TXT_EMAIL, email);
		sendkeyToElement(driver, LoginPageUI.TXT_PASSWORD, password);
		clickToElement(driver, LoginPageUI.BTT_LOGIN);
		return PageGeneratorManager.getMyAccountPageObject(driver);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.REGISTER_OPTION);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public String headerMessage() {
		waitForElementVisible(driver, HomePageUI.MSG_SUCCESS);
		getElementText(driver, HomePageUI.MSG_SUCCESS);
		return getElementText(driver, HomePageUI.MSG_SUCCESS);
	}

	public HomePageObject logout() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_OPTION);
		return PageGeneratorManager.getHomePageObject(driver);
	}

}
