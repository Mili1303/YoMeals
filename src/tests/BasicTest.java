package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;
import pages.SearchResultPage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	protected SoftAssert softAssert;
	protected LocationPopupPage locationPage;
	protected LoginPage loginPage;
	protected NotificationSystemPage notificationPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage summaryPage;
	protected SearchResultPage searchPage;
	protected String baseUrl;
	protected String email;
	protected String password;

//	configuring driver
	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.waiter = new WebDriverWait(driver, 10);
		this.softAssert = new SoftAssert();

		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.locationPage = new LocationPopupPage(driver, js, waiter);
		this.loginPage = new LoginPage(driver, js, waiter);
		this.profilePage = new ProfilePage(driver, js, waiter);
		this.notificationPage = new NotificationSystemPage(driver, js, waiter);
		this.authPage = new AuthPage(driver, js, waiter);
		this.mealPage = new MealPage(driver, js, waiter);
		this.summaryPage = new CartSummaryPage(driver, js, waiter);
		this.searchPage = new SearchResultPage(driver, js, waiter);
		
		this.baseUrl = "http://demo.yo-meals.com/";
		this.email = "customer@dummyid.com";
		this.password = "12345678a";
	}

	@AfterMethod
	public void cleanup(ITestResult results) throws IOException {

//	taking a screenshot if test fails
		if (ITestResult.FAILURE == results.getStatus()) {

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			String file = new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss'.png'").format(new Date());
			FileHandler.copy(source, new File("screenshots/" + results.getName() + "--" + file));
		}
//	quitting the browser		
		this.driver.quit();
	}

}
