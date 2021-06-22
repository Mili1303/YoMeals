package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {
	
	public By account = By.xpath("//div[@class='accounts-link accounts-popup']/ul/li/a");
	public By myAccount = By.xpath("//div[@class='my-account-dropdown']/ul/li/a");
	public By logout = By.xpath("//div[@class='my-account-dropdown']/ul/li[2]/a");
	
	public AuthPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public WebElement getAccount() {
		return this.driver.findElement(account);
	}

	public WebElement getMyAccount() {
		return this.driver.findElement(myAccount);
	}

	public WebElement getLogout() {
		return this.driver.findElement(logout);
	}

	public void logout() {
		this.getAccount().click();
		waiter.until(ExpectedConditions.visibilityOf(getLogout()));
		this.getLogout().click();
	}

}
