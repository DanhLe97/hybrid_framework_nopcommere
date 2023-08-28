package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_lINK);
		clickToElement(driver, HomePageUI.REGISTER_lINK);
	}

}
