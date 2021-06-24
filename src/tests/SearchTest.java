package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BasicTest {

	@Test
	public void searchResults() throws InterruptedException, IOException {

		// importing data file
		File file = new File("data/data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");

		// navigating to page
		this.driver.navigate().to(baseUrl + "meals");
		
		// setting the location
		this.locationPage.setLocation("City Center - Albany");

		// opening every link and setting every location
		for (int i = 1; i < 7; i++) {
			String url = sheet.getRow(i).getCell(1).getStringCellValue();
			this.driver.get(url);
			Thread.sleep(1000);
			
			String location = sheet.getRow(i).getCell(0).getStringCellValue();
			this.locationPage.locationPopUp();
			this.locationPage.setLocation(location);
			Thread.sleep(1000);

			int results = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
			int number = this.searchPage.getNumber();
			Thread.sleep(1000);

			this.softAssert.assertEquals(number, results, "[ERROR] Number of products doesn't match");
			Thread.sleep(1000);


			for (int j = 3; j < 3 + results; j++) {
				String meal = sheet.getRow(i).getCell(j).getStringCellValue();
				String mealName = searchPage.getNames().get(j - 3);
				Thread.sleep(2000);
				this.softAssert.assertTrue(mealName.contains(meal), "[ERROR] Product names are different");
			}
			Thread.sleep(3000);
		}
		this.softAssert.assertAll();
	}

}
