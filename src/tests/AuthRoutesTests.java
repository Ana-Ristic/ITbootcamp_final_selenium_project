package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
	
	@Test
	public void ForbidsVisitsToHomeUrlIfNotAuthenticated() throws InterruptedException {
		navPage.getHomeLink().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home" , "ERROR: Incorrect URL.");
	}
	
	@Test
	public void ForbidsVisitsToProfileUrlIfNotAuthenticated() throws InterruptedException {
		navPage.getMyProfileLink().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/profile", "ERROR: Incorrect URL.");
	}
	
	@Test
	public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() throws InterruptedException {
		navPage.getCitiesLink().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/cities", "ERROR: Incorrect URL.");
	}
	
	@Test
	public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() throws InterruptedException {
		navPage.getAdminButton().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/users", "ERROR: Incorrect URL.");
	}

}
