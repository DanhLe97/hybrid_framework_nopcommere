package pageObject.railway;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.railway.BasePageUI;
import pageUIs.railway.BookTicketPageUI;

public class BookTicketPageObject extends BasePage {
	WebDriver driver;

	public BookTicketPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void bookTicket(String departDate, String departStation, String arriveStation, String seatType,
			String ticketAmount) {
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, "Date");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, departDate, "Date");

		sleepInSecond(1);
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, "DepartStation");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, departStation, "DepartStation");

		sleepInSecond(1);
		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, "ArriveStation");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, arriveStation, "ArriveStation");

		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, "SeatType");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, seatType, "SeatType");

		scrollToElement(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, "TicketAmount");
		selectItemInDefaultDropdown(driver, BookTicketPageUI.DROPDOWN_BY_TEXT, ticketAmount, "TicketAmount");
		scrollToElement(driver, BookTicketPageUI.BUTTON_BOOKTICKET);
		clickToElement(driver, BookTicketPageUI.BUTTON_BOOKTICKET);
	}

	public String getTicketInfo(String columnName, String rowNumber) {
//		scrollToElement(driver, BookTicketPageUI.COLUMN_INDEX_BY_NAME, columnName);
//		int columnIndex = getElementSize(driver, BookTicketPageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		String[] tableData = {"Depart Station", "Arrive Station", "Seat Type", "Depart Date", "Book Date", "Expired Date", "Amount", "Total Price"};

        // Element to find
        String elementToFind = columnName;

        // Get the index of the element
        int columnIndex = findIndex(tableData, elementToFind)+1;

		getElementText(driver, BookTicketPageUI.LABEL_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		return getElementText(driver, BookTicketPageUI.LABEL_BY_COLUMN_AND_ROW_INDEX, rowNumber,
				String.valueOf(columnIndex));

	}
	public Object clickToMenuItem(String itemName) {
		waitForElementClickable(driver, BasePageUI.MENU_ITEM_BY_NAME, itemName);
		clickToElement(driver, BasePageUI.MENU_ITEM_BY_NAME, itemName);
		switch (itemName) {
		case "Home":

			return PageGeneratorManager.getHomePage(driver);
		case "Register":
			return PageGeneratorManager.getRegisterPage(driver);
		case "Book ticket":
			return PageGeneratorManager.getBookTicketPage(driver);
		case "Timetable":
			return PageGeneratorManager.getTimetablePage(driver);
		case "Ticketprice":
			return PageGeneratorManager.getTicketpricePage(driver);
		case "Log out":
			return PageGeneratorManager.getHomePage(driver);
		case "Login":
			return PageGeneratorManager.getLoginPage(driver);
		case "FAQ":
			return PageGeneratorManager.getFAQPage(driver);
		default:
			throw new IllegalArgumentException("Unexpected value: " + itemName);
		}
	}

}
