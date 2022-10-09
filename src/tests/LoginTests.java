package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
	
	@Test (priority = 100)
	public void VisitsTheLoginPage(){
		driver.navigate().to(baseUrl);
		navPage.getLanguageButton().click();
		navPage.getEnLanguageButton().click();
		navPage.getLoginButton().click();
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "ERROR: Incorrect URL.");
	}
	
	@Test (priority = 200)
	public void ChecksInputTypes(){
		navPage.getLoginButton().click();
		Assert.assertEquals(loginPage.getEmail().getAttribute("type"),"email", "ERROR: Incorrect atribut.");
		Assert.assertEquals(loginPage.getPassword().getAttribute("type"),"password", "ERROR: Incorrect atribut.");
	}
	
	@Test (priority = 300)
	public void DisplaysErrorsWhenPasswordIsWrong() {
		
	}

	@Test (priority = 400)
	public void DisplaysErrorsWhenUserDoesNotExist() {
		
	}
	
	@Test (priority = 500)
	public void Login() throws InterruptedException {
		navPage.getLoginButton().click();
		loginPage.getEmail().sendKeys("admin@admin.com");
		loginPage.getPassword().sendKeys("12345");
		loginPage.getLoginButton().click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home", "ERROR: Incorrect URL.");
	}
	
	@Test (priority = 600)
	public void Logout() {
		boolean isLogoutButtonVisible = navPage.getLogoutButton().isDisplayed();
		Assert.assertTrue(isLogoutButtonVisible, "ERROR: Logout button is not visible");
		navPage.getLogoutButton().click();
	}
	
	
}
