package pageObject.railway;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.railway.BookTicketPageUI;

public class BookTicketPageObject extends BasePage {
	WebDriver driver;

	public BookTicketPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "Date");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, departDate, "Date");
		
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "DepartStation");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, departStation, "DepartStation");
		
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "ArriveStation");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, arriveStation, "ArriveStation");
		
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "SeatType");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, seatType, "SeatType");
		
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_NAME, "TicketAmount");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_NAME, ticketAmount, "TicketAmount");
		scrollToElement(driver, BookTicketPageUI.BUTTON_BOOKTICKET);
		clickToElement(driver, BookTicketPageUI.BUTTON_BOOKTICKET);
	}

}
