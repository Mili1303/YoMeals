package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {
	
	public By message = By.xpath("○	//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]");
	
	public WebElement getMessage() {
		return this.driver.findElement(message);
	}
	
	public String getMessageText() {
		return this.driver.findElement(message).getText();
	}
	
	public void waitTillMessageDissappears() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.attributeContains(By.xpath(" //*[contains(@class, 'system_message')]"),
				"style", "display: none;"));
	}
	


}
