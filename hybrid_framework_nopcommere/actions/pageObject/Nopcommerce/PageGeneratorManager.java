package pageObject.Nopcommerce;

import org.openqa.selenium.WebDriver;

import pageObject.NopcommerceAdmin.AdminDashBoardPageObject;
import pageObject.NopcommerceAdmin.AdminLoginPageObject;

public class PageGeneratorManager {
	
	public static UserHomePageObject getUserHomePage (WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static LoginPageObject getUserLoginPage (WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static UserRegisterPageObject getUserRegisterPage (WebDriver driver) {
		return new UserRegisterPageObject(driver); 
	}
	public static UserCustomerInforPageObject getUserCustomerInforPage (WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	public static UserMyProductReviewPageObject getUserProductReviewPage (WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	public static UserRewardPointsPageObject getUserRewardPointPage (WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}
	public static UserAddressPageObject getUserAddressPage (WebDriver driver) {
		return new UserAddressPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage (WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminDashBoardPageObject getAdminHomePage (WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}
}
