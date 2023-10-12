package pageObject.NopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.liveGuru.PageGeneratorManager;
import pageUIs.NopcommerceAdmin.AdminDashBoardPageUI;
import pageUIs.NopcommerceUser.HomePageUI;

public class AdminDashBoardPageObject extends BasePage{
	private WebDriver driver;
	
	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardPageDisplayed() {
		waitForElementVisible(driver,AdminDashBoardPageUI.DASHBOARD_TITLE);
		
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASHBOARD_TITLE);
	}

//	public AdminLoginPageObject logout() {
//		waitForElementVisible(driver, AdminDashBoardPageUI.LOGOUT_LINK);
//		clickToElement(driver, AdminDashBoardPageUI.LOGOUT_LINK);
//		return pageObject.Nopcommerce.PageGeneratorManager.getAdminLoginPage(driver);
//	}
}
