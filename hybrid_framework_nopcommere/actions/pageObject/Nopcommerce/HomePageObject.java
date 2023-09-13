package pageObject.Nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_lINK);
		clickToElement(driver, HomePageUI.REGISTER_lINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}
	public boolean isMyAccountLinkIsDisplayed() {
		isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
		return true;
	}
	public CustomerPageObject clickToMyAccountLink() {
		// TODO Auto-generated method stub
		return null;
	}

}
