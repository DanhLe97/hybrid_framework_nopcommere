package javaBasic;

public class Topic_14_StringFormat {

	public static final String TXT_FIRTNAME="//input[@id='firstname']";
	public static final String TXT_MIDNAME="//input[@id='middlename']";
	public static final String TXT_LASTNAME="//input[@id='lastname']";
	public static final String TXT_PASSWORD="//input[@id='password']";
	public static final String TXT_CONFIRMPASSWORD="//input[@id='confirmation']";
	public static String DYNAMIC_LINK ="//input[@id='%s']";
		public static void main(String[] args) {
			clickToSideBarLink(TXT_CONFIRMPASSWORD);
			clickToSideBarLink(TXT_FIRTNAME);
			clickToSideBarLink(TXT_LASTNAME);
			clickToSideBarLink(TXT_MIDNAME);
			clickToSideBarLink(TXT_PASSWORD);
			
			clickToSideBarLink(DYNAMIC_LINK, "firstname");
			clickToSideBarLink(DYNAMIC_LINK, "lastname");
			clickToSideBarLink(DYNAMIC_LINK, "middlename");
			clickToSideBarLink(DYNAMIC_LINK, "password");
			clickToSideBarLink(DYNAMIC_LINK, "confirmation");
		}
		public static void clickToSideBarLink(String locator) {
			System.out.println("Click to: "+ locator);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		}
		public static void clickToSideBarLink (String dynamicLocator, String fieldName) {
			String locator = String.format(dynamicLocator, fieldName);
			System.out.println("Click to: "+locator);
}
	}

