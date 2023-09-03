package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_lINK);
		clickToElement(driver, HomePageUI.REGISTER_lINK);
	}
	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}
	public boolean isMyAccountLinkIsDisplayed() {
		isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
		return true;
	}

}
