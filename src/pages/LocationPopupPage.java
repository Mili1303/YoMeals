package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {
  
	public By location = By.xpath("//div[@class=\"location-selector\"]/a");
	public By close = By.className("close-btn");
	public By keyword = By.xpath("//*[@id='locality_keyword']");
	public By locationItem = By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/..");
	public By locationInput = By.xpath("//*[@id='location_id']");
	public By submit = By.xpath("//*[@name='btn_submit']");

	public WebElement getLocation() {
		return this.driver.findElement(location);
	}

	public WebElement getClose() {
		return this.driver.findElement(close);
	}

	public WebElement getKeyword() {
		return this.driver.findElement(keyword);
	}

	public WebElement getLocationItem() {
		return this.driver.findElement(locationItem);
	}

	public WebElement getLocationInput() {
		return this.driver.findElement(locationInput);
	}

	public WebElement getSubmit() {
		return this.driver.findElement(submit);
	}

	public void locationPopUp() {
		this.getLocation().click();
	}

	public void setLocation(String location) {
		this.getKeyword().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript(" arguments[0].value=arguments[1]", this.getLocationItem().getAttribute("data-value"));
		js.executeScript("arguments[0].click();", this.getSubmit());
	}
	
	public void closeWindow() {
		this.getClose().click();
	}


}
