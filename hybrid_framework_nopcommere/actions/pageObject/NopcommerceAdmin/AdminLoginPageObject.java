package pageObject.NopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.Nopcommerce.PageGeneratorManager;
import pageUIs.NopcommerceAdmin.AdminLoginPageUI;
import pageUIs.NopcommerceUser.LoginPageUI;

public class AdminLoginPageObject extends BasePage {
	public WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminDashBoardPageObject login(String email, String password) {
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminHomePage(driver);

	}

}
