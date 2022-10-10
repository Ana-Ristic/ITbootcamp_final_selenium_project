package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
	@Test
	public void VisitTheSignupPage(){
		navPage.getSignupButton().click();
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "ERROR: Incorrect URL.");
	}
	@Test
	public void ChecksInputTypes(){
		navPage.getSignupButton().click();
		Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"),"email", "ERROR: Incorrect atribut.");
		Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"),"password", "ERROR: Incorrect atribut.");
		Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"),"password", "ERROR: Incorrect atribut.");
		
	}
	@Test
	public void DisplaysErrorsWhenUserAlreadyExists(){
		navPage.getSignupButton().click();
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "ERROR: Incorrect URL.");
		signupPage.getNameInput().sendKeys("Another User");
		signupPage.getEmailInput().sendKeys("admin@admin.com");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		Assert.assertEquals(messagePopUpPage.getTextFromPopUpDialog().getText(), "E-mail already exists", "ERROR: Incorrect message.");
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "ERROR: Incorrect URL.");
		
    }
	@Test
	public void Signup(){
		navPage.getSignupButton().click();
		signupPage.getNameInput().sendKeys("Ana Ristic");
		signupPage.getEmailInput().sendKeys("ana.ristic@itbootcamp.rs");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		messagePopUpPage.waitForVerifyYourAccountPopUpToBeVisible();
		Assert.assertEquals(messagePopUpPage.getTextFromVerifyAccountPopUpDialog().getText(), "IMPORTANT: Verify your account", "ERROR: Incorrect message.");
		messagePopUpPage.getVerifyAccountCloseButton().click();
		navPage.getLogoutButton().click();
   }
	
}
