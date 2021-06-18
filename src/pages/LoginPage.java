package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {
	
	public By loginButton = By.xpath("//*[@class=\"filled\"]/a");
	public By username = By.name("username");
	public By password = By.name("password");
	
	public WebElement getLoginButton() {
		return this.driver.findElement(loginButton);
	}
	
	public WebElement getUsername() {
		return this.driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(password);
	}

	@Override
	public boolean exists(WebDriver driver, By by) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
