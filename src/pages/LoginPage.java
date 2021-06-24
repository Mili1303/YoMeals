package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	// locators
	public By loginButton = By.xpath("//*[@class=\"filled\"]/a");
	public By username = By.name("username");
	public By password = By.name("password");
	public By rememberMe = By.name("remember_me");
	public By loginSubmit = By.name("btn_submit");
	
	// constructor
	public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	// get methods for elements needed
	public WebElement getLoginButton() {
		return this.driver.findElement(loginButton);
	}
	
	public WebElement getUsername() {
		return this.driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(password);
	}
	
	public WebElement getRememeberMe() {
		return this.driver.findElement(rememberMe);
	}
	
	public WebElement getLoginSubmit() {
		return this.driver.findElement(loginSubmit);
	}
	
	// method for user login
	public void userLogin(String email, String pass) {
		this.getUsername().sendKeys(email);
		this.getPassword().sendKeys(pass);
		this.getRememeberMe().click();
		this.getLoginSubmit().click();
	}
	

}
