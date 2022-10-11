package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
	
	@Test
	public void ForbidsVisitsToHomeUrlIfNotAuthenticated() throws InterruptedException {
		driver.get(baseUrl + "/home");
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login" , "ERROR: Incorrect URL.");
	}
	
	@Test
	public void ForbidsVisitsToProfileUrlIfNotAuthenticated() throws InterruptedException {
		driver.get(baseUrl + "/profile");
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "ERROR: Incorrect URL.");
	}
	
	@Test
	public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() throws InterruptedException {
		driver.get(baseUrl + "/admin/cities");
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "ERROR: Incorrect URL.");
	}
	
	@Test
	public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() throws InterruptedException {
		driver.get(baseUrl + "/admin/users");
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "ERROR: Incorrect URL.");
	}
}
