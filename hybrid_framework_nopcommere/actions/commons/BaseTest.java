package commons;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		System.out.println("Run on: " + browserName);
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920-1080");
			driver = new FirefoxDriver(options);
		}

		else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			WebDriverManager.chromedriver().browserVersion("104").setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
//			WebDriverManager.chromedriver().browserVersion("104").setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920-1080");
			driver = new ChromeDriver(options);

			if (GlobalConstants.OS_NAME.startsWith("Window")) {
				options.setBinary("");
			} else {

			}
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("brave")) {
			WebDriverManager.chromedriver().driverVersion("117.0.5938.150").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}

	public String getDateTimeRandom() {
		String localTime = LocalTime.now().toString();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		String after = timeStamp.replace(".", "");
		return after = timeStamp.replace(".", "");
	}
	public void switchToLatestTab () {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size()-1));
	}
	public String plusDateFormCurrentDate(int addDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, addDate); // Adding 5 days
		String output = sdf.format(c.getTime());
		return output = sdf.format(c.getTime());
	}
	public void closeTab() {
		driver.close();	
	}
	
}
