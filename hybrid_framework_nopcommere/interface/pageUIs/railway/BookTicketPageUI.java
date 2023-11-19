package pageUIs.railway;

public class BookTicketPageUI {
public static final String DROPDOWN_BY_TEXT = "xpath=//select[@name='%s']";
public static final String BUTTON_BOOKTICKET = "xpath=//input[@value='Book ticket']";
public static final String HEADER_MESAGE = "xpath=//body//div[@id='page']//h1";
public static final String COLUMN_INDEX_BY_NAME = "xpath=//tbody/tr//th[text()='%s']//preceding-sibling::th";
public static final String LABEL_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]";
}
