package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePageObject (WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject (WebDriver driver) {
		return new RegisterPageObject();
	}
	public static LoginPageObject getLoginPageObject (WebDriver driver) {
		return new LoginPageObject();
	}
	public static MyAccountPageObject getMyAccountPageObject (WebDriver driver) {
		return new MyAccountPageObject();
	}

}
