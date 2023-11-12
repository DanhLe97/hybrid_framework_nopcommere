package pageObject.railway;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
public static HomePageObject getHomePage (WebDriver driver) {
	return new HomePageObject(driver);
}
public static LoginPageObject getLoginPage (WebDriver driver) {
	return new LoginPageObject(driver);
}
public static BookTicketPageObject getBookTicketPage (WebDriver driver) {
	return new BookTicketPageObject(driver);
}
public static RegisterPageObject getRegisterPage (WebDriver driver) {
	return new RegisterPageObject(driver);
}
public static TimetablePageObject getTimetablePage (WebDriver driver) {
	return new TimetablePageObject(driver);
}
public static EmailPageObject getEmailPage (WebDriver driver) {
	return new EmailPageObject(driver);
}
public static TicketPricePageObject getTicketpricePage (WebDriver driver) {
	return new TicketPricePageObject(driver);
}
public static FAQPageObject getFAQPage (WebDriver driver) {
	return new FAQPageObject(driver);
}
}
