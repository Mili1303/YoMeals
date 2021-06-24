package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {
	
	// locator
	public By clearAll = By.xpath("//*[@onclick=\"clearCartItems()\"]");

	// constructor
	public CartSummaryPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	// get method for element needed
	public WebElement getClearAll() {
		return this.driver.findElement(clearAll);
	}

	// method for deleting all cart items
	public void clearCart() {
		this.getClearAll().click();
	}

	
	

}
