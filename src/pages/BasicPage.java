package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasicPage {
	protected WebDriver driver;
	
	public abstract boolean exists(WebDriver driver, By by);
}
