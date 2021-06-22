package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
	
	public By edit = By.xpath("By.xpath(\"//div[@class='action-profile']/a[2]\")");
	public By firstName = By.name("user_first_name");
	public By lastName = By.name("user_last_name");
	public By address = By.name("user_address");
	public By phone = By.name("user_phone");
	public By zip = By.name("user_zip");
	public By country = By.id("user_country_id");
	public By state = By.id("user_state_id");
	public By city = By.id("user_city");
	public By photo = By.className("uploadFile-Js");
	public By save = By.name("btn_submit");
	public By upload = By.xpath("By.xpath(\"//*[@id='form-upload']/input\")");
	public By remove = By.className("remove");
	
	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
	public WebElement getEdit() {
		return this.driver.findElement(edit);
	}
	
	public WebElement getFirstName() {
		return this.driver.findElement(firstName);
	}
	
	public WebElement getLastName() {
		return this.driver.findElement(lastName);
	}
	
	public WebElement getAddress() {
		return this.driver.findElement(address);
	}
	
	public WebElement getPhone() {
		return this.driver.findElement(phone);
	}
	
	public WebElement getZip() {
		return this.driver.findElement(zip);
	}
	
	public Select getCountry() {
		WebElement selectCountry = this.driver.findElement(country);
		Select country = new Select(selectCountry);
		return country;
	}
	
	public Select getState() {
		WebElement selectState = this.driver.findElement(state);
		Select state = new Select(selectState);
		return state;
	}
	
	public Select getCity() {
		WebElement selectCity = this.driver.findElement(By.id("user_city"));
		Select city = new Select(selectCity);
		return city;
	}
	
	public WebElement getPhoto() {
		return this.driver.findElement(photo);
	}
	
	public WebElement getSave() {
		return this.driver.findElement(save);
	}
	
	public WebElement getUpload() {
		return this.driver.findElement(upload);
	}
	
	public void uploadImg(String img) {
		js.executeScript("arguments[0].click();", this.getPhoto());
		this.getUpload().sendKeys(img);
	}
	
	public WebElement getRemove() {
		return this.driver.findElement(remove);
	}
	
	public void deleteImg() {
		js.executeScript("arguments[0].click();", this.getRemove());
	}

	public void changeInfo(String firstName, String lastName, String address, String phone, String zip,
			String country, String state, String city) throws InterruptedException {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		
		this.getPhone().clear();
		this.getPhone().sendKeys(phone);
		
		this.getZip().clear();
		this.getZip().sendKeys(zip);
		
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(1000);
		
		this.getState().selectByVisibleText(state);
		Thread.sleep(1000);
		
		this.getCity().selectByVisibleText(city);
		Thread.sleep(4000);
		
		this.getSave().submit();

	}
	

}
