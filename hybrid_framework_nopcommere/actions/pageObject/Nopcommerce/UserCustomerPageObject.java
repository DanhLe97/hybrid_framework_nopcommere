package pageObject.Nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserCustomerPageObject extends BasePage {
protected WebDriver driver;
public UserCustomerPageObject (WebDriver driver) {
	this.driver = driver;
}
}
