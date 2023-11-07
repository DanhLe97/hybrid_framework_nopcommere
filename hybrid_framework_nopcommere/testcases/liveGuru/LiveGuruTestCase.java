package liveGuru;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.AdminCustomersPageObject;
import pageObject.liveGuru.AdminLoginPageObject;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.PageGeneratorManager;
@Test
public class LiveGuruTestCase extends BaseTest {
HomePageObject homePage;
AdminLoginPageObject adminLoginPage;
AdminCustomersPageObject adminCustomerPage;
WebDriverWait explicitWait;

List<String> actualAllCountryValues;
List<String> expectedAllCountryValues;
String adminEmail = "user01";
String adminPassword = "guru99com";
String adminPageURL = "http://live.techpanda.org/index.php/backendlogin/index/index/key/3a127df21957ae4c041cd84e54a7217a/";
String firstName = "001f";	
String lastName = "001l";	
String email = getDateTimeRandom()+"@testing.com";	
String password = "12345678";	


@org.testng.annotations.Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		explicitWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

//	public void TC_01_User_To_Admin() {
//		
//	}

	public void Table_01() throws InterruptedException {
		homePage.registNewAccount(firstName, lastName,email,password);
		homePage.openPageUrl(driver, adminPageURL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminCustomerPage = adminLoginPage.login(adminEmail, adminPassword);
		adminCustomerPage.enterValueToTextboxByColumName("Email",email);
		Thread.sleep(300);
		assertEquals(adminCustomerPage.getSearchResultByColumnName("Email"), email);
		adminCustomerPage.selectSearchResult();
		adminCustomerPage.selectAction("Delete","Submit");
		}
	


//	public void Table_03_Data_Table() {
//		//Đọc dữ liệu của file country.txt ra
//		// Lưu vào 1 List<String> = Expected value = expectedAllCountryValues
//		
//		//Actual value
//		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
//		assertEquals(actualAllCountryValues, expectedAllCountryValues);
//	}
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {

	}

	public void Table_05() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	WebDriver driver;
	
}