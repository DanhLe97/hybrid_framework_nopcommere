package pageUIs.JQuery;

public class HomePageUI {
public static final String PAGINATION_BY_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
public static final String DISPLAYED_PAGE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
public static final String TOTAL_PAGINATION = "//li[@class='qgrd-pagination-page']";
public static final String PAGINATION_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
public static final String ALL_ROW_EACH_PAGE = "//body//tr";
public static final String ALL_ROW_COUNTRY_EACH_PAGE = "//tbody/tr/td[@data-key='country']";

public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//th[text()='%s']/preceding-sibling::th";
public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]/input";
public static final String DYNAMIC_DROPDOWN_BY_COLUMN_AND_ROW_INDEX= "xpath=//tbody//tr[%s]//td[%s]//select";
public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]//select";
public static final String LOAD_BUTTON = "xpath=//button[@id='load']";


}