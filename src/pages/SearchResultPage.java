package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {
	
	// locator
	public By searchResults = By.xpath("//*[@class='product-name']/a");

	// constructor
	public SearchResultPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	// get method for all search results
	public List<WebElement> getSearchResults() {
		return this.driver.findElements(searchResults);
	}

	// method that returns the names of all meals
	public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < this.getSearchResults().size(); i++) {
			names.add(this.getSearchResults().get(i).getText());
		}
		return names;
	}

	// method that returns the number of search results
	public int getNumber() {
		return this.getSearchResults().size();
	}


}
