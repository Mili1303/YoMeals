package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {
	
	public By favourite = By.id("item_119");
	public By add = By.xpath("//*[@class=\"price-feature--wrapper\"]/div[2]/a");
	public By quantity = By.name("product_qty");

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	public WebElement getFavourite() {
		return this.driver.findElement(favourite);
	}
	
	public void addToFavourite() {
		this.getFavourite().click();
	}
	
	public WebElement getAdd() {
		return this.driver.findElement(add);
	}

	public WebElement getQuantity() {
		return this.driver.findElement(quantity);
	}

	public void addToCart(int quantity1) throws InterruptedException {
		this.getQuantity().click();
		Thread.sleep(1000);
		this.getQuantity().clear();
		Thread.sleep(2000);
		
		String quantity2 = Integer.toString(quantity1);
		this.getQuantity().sendKeys(quantity2);
		this.getAdd().click();

	}

}
