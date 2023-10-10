package liveGuru;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import commons.BaseTest;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.MyAccountPageObject;
import pageObject.liveGuru.PageGeneratorManager;
import pageObject.liveGuru.RegisterPageObject;

public class LiveGuruTestCase extends BaseTest {
private WebDriver driver;
private String firstName;
private String lastName;
private String password;
private String email;
private HomePageObject homePage;
private RegisterPageObject registerPage;
private LoginPageObject loginPage;
private MyAccountPageObject myAccountPage;
@org.testng.annotations.Parameters("browser")
@BeforeClass
public void beforeClass(String browserName) {
	driver = getBrowserDriver("chrome");
	
	homePage = pageObject.liveGuru.PageGeneratorManager.getHomePageObject(driver);
	firstName = "w_firstName";
	lastName = "w_lastName";
	password = "123456";
	email = "afc" + generateFakeNumber() + "@mailinator.com";
//	notFoundEmailAddress = "afc" + generateFakeNumber() + "@email.com";
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.techpanda.org/");

}
@Test

public void TC_01_Register_Success() {
	homePage.clickToRegisterLink();
	registerPage = PageGeneratorManager.getRegisterPageObject(driver);
	registerPage.createNewAccount(driver, firstName, lastName, email, password, password);
	homePage = PageGeneratorManager.getHomePageObject(driver);
	String expectedMsg = "Thank you for registering with Main Website Store.";
	assertEquals(homePage.headerMessage(), expectedMsg);
	homePage.logout();
}
public void TC_02_Verify_User_Information_Correct_With_Register () {
	homePage.login(email, password);
	myAccountPage = PageGeneratorManager.getMyAccountPageObject(driver);
	
}
public int generateFakeNumber() {
	Random rand = new Random();
	return rand.nextInt(9999);
}
@AfterClass
public void afterClass() {
	driver.quit();

}
}
