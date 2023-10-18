package pageUIs.JQuery;

public class HomePageUI {
public static final String PAGINATION_BY_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
public static final String DISPLAYED_PAGE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
public static final String TOTAL_PAGINATION = "//li[@class='qgrd-pagination-page']";
public static final String PAGINATION_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
public static final String ALL_ROW_EACH_PAGE = "//body//tr";
public static final String ALL_ROW_COUNTRY_EACH_PAGE = "//tbody/tr/td[@data-key='country']";


}
