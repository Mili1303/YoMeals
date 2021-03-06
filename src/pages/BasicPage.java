package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	
	// constructor
	public BasicPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super();
		this.driver = driver;
		this.js = js;
		this.waiter = waiter;
	}
}
