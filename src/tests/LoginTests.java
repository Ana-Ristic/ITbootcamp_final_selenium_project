package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
	
	@Test 
	public void VisitsTheLoginPage(){
		driver.navigate().to(baseUrl);
		navPage.getLanguageButton().click();
		navPage.getENLanguageButton().click();
		navPage.getLoginButton().click();
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "ERROR: Incorrect URL.");
	}
	
	@Test 
	public void ChecksInputTypes(){
		navPage.getLoginButton().click();
		Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),"email", "ERROR: Incorrect atribut.");
		Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),"password", "ERROR: Incorrect atribut.");
	}
	
	@Test 
	public void DisplaysErrorsWhenPasswordIsWrong() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		Assert.assertEquals(messagePopUpPage.getTextFromPopUpDialog().getText(), "User does not exists", "ERROR: Incorrect message.");
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "ERROR: Incorrect URL.");
		
	}

	@Test 
	public void DisplaysErrorsWhenUserDoesNotExist() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		Assert.assertEquals(messagePopUpPage.getTextFromPopUpDialog().getText(), "Wrong password", "ERROR: Incorrect message.");
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "ERROR: Incorrect URL.");
		
	}
	
	@Test 
	public void Login() throws InterruptedException {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home", "ERROR: Incorrect URL.");
	}
	
	@Test 
	public void Logout() {
		boolean isLogoutButtonVisible = navPage.getLogoutButton().isDisplayed();
		Assert.assertTrue(isLogoutButtonVisible, "ERROR: Logout button is not visible");
		navPage.getLogoutButton().click();
	}
}
