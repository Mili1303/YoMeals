package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemtest extends BasicTest {

	// Add meal to cart test
	@Test
	public void addToCart() throws InterruptedException {
		
		// navigating to page
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		
		// closing popup window
		this.locationPage.closeWindow();
		
		//adding items to cart 
		this.mealPage.addToCart(5);
		
		// verifying the error message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("The Following Errors Occurred:"), "[ERROR] No message shown");
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Please Select Location"), "[ERROR] No message shown");
		
		// waiting for message to dissappear
		this.notificationPage.waitTillMessageDissappears();

		// Setting location
		this.locationPage.locationPopUp();
		this.locationPage.setLocation("City Center - Albany");
		
		// adding items to cart
		this.mealPage.addToCart(5);
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Meal Added To Cart"), " [ERROR] Adding to cart was unsuccessful");
	}

//	add meal to favorite test
	@Test
	public void addToFavorites() throws InterruptedException {

		// navigation to the page
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		
		// closing popup window
		this.locationPage.closeWindow();
		
		// adding meal to favorites
		this.mealPage.addToFavorite();

		// verifying the login warning message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Please login first!"), " [ERROR] Unexpected login message");
		
		// waiting for the message to dissappear
		this.notificationPage.waitTillMessageDissappears();

		// navigating the login page
		this.driver.navigate().to(baseUrl + "guest-user/login-form");
		Thread.sleep(1000);
		
		// useri login
		this.loginPage.userLogin(email, password);

		// navigating to meals page
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		
		// adding the meal to favorites
		this.mealPage.addToFavorite();
		
		//verifying the message for items being added to favorites
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Product has been added to your favorites"), " [ERROR] Product has not been added to your favorites");
		
		// waiting for the message to dissappear
		this.notificationPage.waitTillMessageDissappears();


	}

//	clear cart test
	@Test
	public void clearCart() throws InterruptedException, IOException {
		
		//navigating to meals page
		this.driver.navigate().to(baseUrl + "meals");
		Thread.sleep(1000);
		
		// setting the location
		this.locationPage.setLocation("City Center - Albany");
		Thread.sleep(1000);

		// data from the "data" file
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");

		// adding meals with defined quantity
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			String meals = sheet.getRow(i).getCell(0).getStringCellValue();
			int quantity = (int) sheet.getRow(i).getCell(1).getNumericCellValue();

			this.driver.navigate().to(meals);
			this.mealPage.addToCart(5);
			
			// verifying the add to cart message
			this.softAssert.assertTrue(this.notificationPage.getMessageText().contains("Meal Added To Cart"), "[ERROR] Cart is empty");
		}

		// removing the items from cart
		this.summaryPage.clearCart();
		
		// verifyin the message that meals are removed
		Assert.assertTrue(this.notificationPage.getMessageText().contains("All meals removed from Cart successfully"), "[ERROR] Items have not been removed");
		
		// waiting for the message to dissappear
		this.notificationPage.waitTillMessageDissappears();


	}

}
