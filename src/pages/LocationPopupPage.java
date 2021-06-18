package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage{
	
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
	
	

	@Override
	public boolean exists(WebDriver driver, By by) {
		// TODO Auto-generated method stub
		return false;
	}

}
