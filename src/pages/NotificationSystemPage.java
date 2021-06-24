package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	// locator
	public By message = By.xpath("○	//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]");
	
	// constructor
	public NotificationSystemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	// get method for element that shows the message
	public WebElement getMessage() {
		return this.driver.findElement(message);
	}
	
	// method that returns the message
	public String getMessageText() {
		return this.driver.findElement(message).getText();
	}
	
	// method that waits for the message to dissappear
	public void waitTillMessageDissappears() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.attributeContains(By.xpath(" //*[contains(@class, 'system_message')]"),
				"style", "display: none;"));
	}
	


}
