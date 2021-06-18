package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {
	
	public By loginButton = By.xpath("//*[@class=\"filled\"]/a");
	
	public WebElement getLoginButton() {
		return this.driver.findElement(loginButton);
	}

	@Override
	public boolean exists(WebDriver driver, By by) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
