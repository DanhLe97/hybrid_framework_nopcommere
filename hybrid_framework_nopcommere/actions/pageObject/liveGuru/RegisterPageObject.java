package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	public HomePageObject createNewAccount(WebDriver driver, String firstname, String lastname, String email, String password,
			String confirmpassword) {
		sendkeyToElement(driver, RegisterPageUI.TXT_FIRTNAME, firstname);
		sendkeyToElement(driver, RegisterPageUI.TXT_LASTNAME, lastname);
		sendkeyToElement(driver, RegisterPageUI.TXT_EMAIL, email);
		sendkeyToElement(driver, RegisterPageUI.TXT_PASSWORD, password);
		sendkeyToElement(driver, RegisterPageUI.TXT_CONFIRMPASSWORD, confirmpassword);
		clickToElement(driver, RegisterPageUI.BTT_REGISTER);
		return PageGeneratorManager.getHomePageObject(driver);
	}
}
