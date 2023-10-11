package pageObject.Nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static UserHomePageObject getHomePage (WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static AdminLoginPageObject getLoginPage (WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPage (WebDriver driver) {
		return new RegisterPageObject(driver); 
	}
	public static UserCustomerInforPageObject getCustomerInforPage (WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	public static UserMyProductReviewPageObject getMyProductReviewPage (WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	public static UserRewardPointsPageObject getRewardPointPage (WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}
	public static AddressPageObject getAddressPage (WebDriver driver) {
		return new AddressPageObject(driver);
	}
}
