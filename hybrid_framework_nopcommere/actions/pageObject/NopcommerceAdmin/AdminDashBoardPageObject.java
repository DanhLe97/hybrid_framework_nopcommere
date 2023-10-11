package pageObject.NopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopcommerceUser.HomePageUI;

public class AdminDashBoardPageObject extends BasePage{
	private WebDriver driver;
	
	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
