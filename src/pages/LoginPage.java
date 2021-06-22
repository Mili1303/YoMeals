package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {
	
	public By loginButton = By.xpath("//*[@class=\"filled\"]/a");
	public By username = By.name("username");
	public By password = By.name("password");
	public By rememberMe = By.name("remember_me");
	public By loginSubmit = By.name("btn_submit");
	
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
	
	public void userLogin(String email, String pass) {
		this.getUsername().sendKeys(email);
		this.getPassword().sendKeys(pass);
		this.getRememeberMe().click();
		this.getLoginSubmit().click();
	}
	

}
