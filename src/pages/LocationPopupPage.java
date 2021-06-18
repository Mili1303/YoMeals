package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage{
	
	public By location = By.xpath("//div[@class=\"location-selector\"]/a");
	
	public WebElement getLocation() {
		return this.driver.findElement(location);
	}

	@Override
	public boolean exists(WebDriver driver, By by) {
		// TODO Auto-generated method stub
		return false;
	}

}
