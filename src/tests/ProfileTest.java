package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

// edit profile test
	@Test
	public void editProfile() throws InterruptedException {
		// loading the page
		this.driver.navigate().to(baseUrl + "guest-user/login-form");

		// closing the popup window
		this.locationPage.closeWindow();

		// user login
		this.loginPage.userLogin("stojanovicmilica1303@yahoo.com", "Micatest13");

		// verifying the login message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Login Successfull"),
				"[ERROR] Unexpected login message");

		// navigating to the page
		this.driver.navigate().to(baseUrl + "member/profile");

		// editing profile details
		this.profilePage.editProfile("Pera", "Peric", "Cara Dusana 5", "+38162555333", "21101", "Serbia", "Vojvodina",
				"Novi Sad");

		// verifying the setup message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Setup Successful"),
				" [ERROR] Unexpected setup message");

		// waiting for message to dissappear
		this.notificationPage.waitTillMessageDissappears();

		// logging out
		this.authPage.logout();

		// verifying the logout message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Logout Successfull!"),
				" [ERROR] Unexpected logout message");
	}

//	change profile image test
	@Test
	public void changeImg() throws IOException {

		// navigating to the page
		this.driver.navigate().to(baseUrl + "/guest-user/login-form");

		// closing the popup window
		this.locationPage.closeWindow();

		// user login
		this.loginPage.userLogin("stojanovicmilica1303@yahoo.com", "Micatest13");

		// verifying the login message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Login Successfull"),
				"[ERROR] Unexpected login message");

		// waiting for message to dissappear
		this.notificationPage.waitTillMessageDissappears();

		// navigating to the page
		this.driver.navigate().to(baseUrl + "/member/profile");

		// uploading the photo
		String photo = new File("C:\\Users\\Milica\\Desktop\\IT Bootcamp\\FinalProject\\YoMeals\\img")
				.getCanonicalPath();
		this.profilePage.uploadPhoto(photo);

		// verifying the image upload message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Profile Image Uploaded Successfully"),
				" [ERROR] Image Upload failed");

		// waiting for message to dissappear
		this.notificationPage.waitTillMessageDissappears();

		// deleting the photo
		this.profilePage.deleteImg();

		// verifying the delete photo message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Profile Image Deleted Successfully"),
				"Profile Image Deleted Failed");

		// wait for the message to dissappear
		this.notificationPage.waitTillMessageDissappears();

		// user logout
		this.authPage.logout();

		// verifying the logout message
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Logout Successfull!"),
				" [ERROR] Unexpected logout message");

		// waiting for logout message to dissappear
		this.notificationPage.waitTillMessageDissappears();
	}
}
