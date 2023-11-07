package pageUIs.liveGuru;

public class AdminCustomersPageUI {
	public static final String LABEL_USER_EMAIL = "xpath=//tbody//td[4]";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//th[descendant::span[text()='%s']]//preceding-sibling::th";
	public static final String SEARCH_RESULT_BY_COLUMN_INDEX = "xpath=//*[@id=\"customerGrid_table\"]/tbody/tr/td[%s]";
	public static final String TEXTBOX_BY_COMLUN_INDEX = "xpath=//th[%s]//input";
	public static final String SEARCH_RESULT_CHECKBOX = "xpath=//input[@type='checkbox']";
	public static final String ACTION_DROPDOWN = "xpath=//select[@id='customerGrid_massaction-select']";
	public static final String BUTTON_BY_NAME = "xpath=//button[@title='%s']";
}
