package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.AdminLoginUI;

	public class AdminLoginPageObject extends BasePage {
		private WebDriver driver;

		public AdminLoginPageObject(WebDriver driver) {
			this.driver = driver;
		}


	public AdminCustomersPageObject login (String adminEmail, String adminPassword) {
		waitForElementVisible(driver, AdminLoginUI.TEXTBOX_BY_NAME, "username");
		sendkeyToElement(driver, AdminLoginUI.TEXTBOX_BY_NAME, adminEmail, "username");
		sendkeyToElement(driver, AdminLoginUI.TEXTBOX_BY_NAME,adminPassword, "login");
		clickToElement(driver, AdminLoginUI.BTN_LOGIN);
		clickToElement(driver, AdminLoginUI.BTN_CLOSE_INCOM_MSG);
		return PageGeneratorManager.getAdminCustomersPageObject(driver);
	}
}