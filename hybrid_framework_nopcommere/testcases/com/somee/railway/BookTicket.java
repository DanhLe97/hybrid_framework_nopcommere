package com.somee.railway;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.railway.BookTicketPageObject;
import pageObject.railway.EmailPageObject;
import pageObject.railway.HomePageObject;
import pageObject.railway.LoginPageObject;
import pageObject.railway.PageGeneratorManager;
import pageObject.railway.RegisterPageObject;
import pageObject.railway.TimetablePageObject;

public class BookTicket extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	EmailPageObject emailPage;
	BookTicketPageObject bookTicketPage;
	TimetablePageObject timeTablePage;

	private String emailName = getDateTimeRandom();
	private String emailDomain = "pokemail.net";
	private String password = getDateTimeRandom();
	private String pidNumber = "123456789";
	private String email = emailName + "@" + emailDomain;
	private String departDate = plusDateFormCurrentDate(15);
	private String departStation = "Nha Trang";
	private String arriveStation = "Huế";
	private String seatType = "Soft seat with air conditioner";
	private String ticketAmount = "1";

	@org.testng.annotations.Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(@Optional("firefox") String browserName,
			@Optional("http://saferailway.somee.com/Page/HomePage.cshtml") String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Create_And_Active_Account();
		System.out.println(email);
		System.out.println(password);

	}

	@Test
	public void TC_12_User_Can_Book_01_Ticket_At_ATime() {
		loginPage = (LoginPageObject) homePage.clickToMenuItem("Login");
		loginPage.login(email, password);
		bookTicketPage = (BookTicketPageObject) homePage.clickToMenuItem("Book ticket");
		bookTicketPage.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);
	
		assertEquals(departDate, bookTicketPage.getTicketInfo("Depart Date", "2"));
		assertEquals(departStation, bookTicketPage.getTicketInfo("Depart Station", "2"));
		assertEquals(arriveStation, bookTicketPage.getTicketInfo("Arrive Station", "2"));

		assertEquals(seatType, bookTicketPage.getTicketInfo("Seat Type", "2"));
		assertEquals(ticketAmount, bookTicketPage.getTicketInfo("Amount", "2"));
		bookTicketPage.clickToMenuItem("Book ticket");
	}
	@Test
	public void TC_13_User_Can_Book_Many_Tickets_At_ATime() {
		loginPage = (LoginPageObject) homePage.clickToMenuItem("Login");
		loginPage.login(email, password);
		bookTicketPage = (BookTicketPageObject) homePage.clickToMenuItem("Book ticket");
		bookTicketPage.bookTicket(plusDateFormCurrentDate(28), "Nha Trang", "Sài Gòn",  "Soft seat with air conditioner", "5");
	
		assertEquals(plusDateFormCurrentDate(28), bookTicketPage.getTicketInfo("Depart Date", "2"));
		assertEquals("Nha Trang", bookTicketPage.getTicketInfo("Depart Station", "2"));
		assertEquals("Sài Gòn", bookTicketPage.getTicketInfo("Arrive Station", "2"));

		assertEquals("Soft seat with air conditioner", bookTicketPage.getTicketInfo("Seat Type", "2"));
		assertEquals("5", bookTicketPage.getTicketInfo("Amount", "2"));
	}
	@Test
	public void TC_13_User_Can_Check_Price_Of_Ticket_From_Timetable() {
		timeTablePage = (TimetablePageObject) bookTicketPage.clickToMenuItem("Timetable");
		timeTablePage.checkPriceOfARoutine("Đà Nẵng","Sài Gòn");
		timeTablePage.checkPriceOfARoutine("Đà Nẵng","Sài Gòn");
	}

	public void Create_And_Active_Account() {
		registerPage = (RegisterPageObject) homePage.clickToMenuItem("Register");
		registerPage.registNewAccount(email, password, pidNumber);
		registerPage.openPageUrl(driver, "https://www.guerrillamail.com/inbox");
		emailPage = PageGeneratorManager.getEmailPage(driver);
		registerPage = emailPage.verifyRegistedAccount(emailName, emailDomain);
		closeTab();
		switchToLatestTab();
		registerPage.clickToMenuItem("Home");

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();

	}
}
