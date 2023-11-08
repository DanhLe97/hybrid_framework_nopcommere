package pageObject.railway;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class TimetablePageObject extends BasePage {
	WebDriver driver;

	public TimetablePageObject(WebDriver driver) {
		this.driver = driver;
	}

}
