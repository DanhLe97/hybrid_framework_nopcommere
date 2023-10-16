package pageObject.Nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopcommerceUser.HomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	public boolean isMyAccountLinkIsDisplayed() {
		isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
		return true;
	}
	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver,  HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
//	public void logout() {
//		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
//		clickToElement(driver, HomePageUI.LOGOUT_LINK);
//	}

}
