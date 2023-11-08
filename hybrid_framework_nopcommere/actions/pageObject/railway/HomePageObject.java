package pageObject.railway;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.railway.BasePageUI;
import pageUIs.railway.RegisterPageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToMenuItem(String itemName) {
		waitForElementClickable(driver, BasePageUI.MENU_ITEM_BY_NAME, itemName);
		clickToElement(driver, BasePageUI.MENU_ITEM_BY_NAME, itemName);
		return PageGeneratorManager.getRegisterPage(driver);
	}


}
