package pageObject.NopcommerceAdmin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static AdminDashBoardPageObject getHomePage (WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}
	public static AdminLoginPageObject getLoginPage (WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPage (WebDriver driver) {
		return new RegisterPageObject(driver); 
	}
	public static AddressPageObject getAddressPage (WebDriver driver) {
		return new AddressPageObject(driver);
	}
}
