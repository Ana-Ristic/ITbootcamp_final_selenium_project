package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
//	@Test
//	public void VisitsTheAdminCitiesPageAndListCities() throws InterruptedException {
//		navPage.getLoginButton().click();
//		loginPage.getEmailInput().sendKeys("admin@admin.com");
//		loginPage.getPasswordInput().sendKeys("12345");
//		loginPage.getLoginButton().click();
//		navPage.getAdminButton().click();
//		navPage.getCitiesLink().click();
//		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/cities", "ERROR: Incorrect URL.");
//		Thread.sleep(5000);
//	}
	
//	@Test
//	public void ChecksInputTypesForCreateEditNewCity() throws InterruptedException {
//		wait.until(ExpectedConditions.elementToBeClickable(By.className("btnNewItem")));
//		navPage.getAdminButton().click();
//		navPage.getCitiesLink().click();
//		citiesPage.getNewItemButton().click();
//		citiesPage.waitForEditDialogtoBeVisible();
//		Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"),"text", "ERROR: Incorrect atribut.");
//	}
	
//	@Test
//	public void CreateNewCity() {
//		navPage.getLoginButton().click();
//		loginPage.getEmailInput().sendKeys("admin@admin.com");
//		loginPage.getPasswordInput().sendKeys("12345");
//		loginPage.getLoginButton().click();
//		navPage.getAdminButton().click();
//		navPage.getCitiesLink().click();
//		citiesPage.getNewItemButton().click();
//		citiesPage.getNewItemInput().sendKeys("Bor");
//		citiesPage.getSaveButtonFromDialog().click();
//		citiesPage.waitForMessageDialogToBeVisible();
//		Assert.assertTrue(citiesPage.getMessageDialogText().getText().contains("Saved successfully"), "ERROR: Incorrect message.");
//	} 
	
//	@Test
//	public void EditCity() {
//		navPage.getLoginButton().click();
//		loginPage.getEmailInput().sendKeys("admin@admin.com");
//		loginPage.getPasswordInput().sendKeys("12345");
//		loginPage.getLoginButton().click();
//		navPage.getAdminButton().click();
//		navPage.getCitiesLink().click();
//		citiesPage.getSearchInput().sendKeys("Barranquilla");
//		citiesPage.waitForNumberOfRows(1);
//		citiesPage.getEditButton(1).click();
//		citiesPage.getNewItemInput().sendKeys("Novi Sad");
//		citiesPage.getSaveButtonFromDialog().click();
//		Assert.assertTrue(citiesPage.getMessageDialogText().getText().contains("Saved successfully"), "ERROR: Incorrect message.");
//		Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), "Bor", "ERROR");
//	}
	
	@Test
	public void SearchCity() throws InterruptedException {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Novi Sad");
		citiesPage.waitForNumberOfRows(1);
		Thread.sleep(5000);
		Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), "Barranquilla", "ERROR");
	}
	
}
