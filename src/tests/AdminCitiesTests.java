package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
		@Test
		public void VisitsTheAdminCitiesPageAndListCities() {
			navPage.getLoginButton().click();
			loginPage.getEmailInput().sendKeys("admin@admin.com");
			loginPage.getPasswordInput().sendKeys("12345");
			loginPage.getLoginButton().click();
			navPage.getAdminButton().click();
			navPage.getCitiesLink().click();
			Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/cities", "ERROR: Incorrect URL.");
		}
		
		@Test
		public void ChecksInputTypesForCreateEditNewCity() {
//			navPage.getLoginButton().click();
			loginPage.getEmailInput().sendKeys("admin@admin.com");
			loginPage.getPasswordInput().sendKeys("12345");
			loginPage.getLoginButton().click();
			navPage.getAdminButton().click();
			navPage.getCitiesLink().click();
			citiesPage.getNewItemButton().click();
			citiesPage.waitForEditDialogtoBeVisible();
			Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"),"text", "ERROR: Incorrect atribut.");
		}
		
		@Test
		public void CreateNewCity() {
//			navPage.getLoginButton().click();
			loginPage.getEmailInput().sendKeys("admin@admin.com");
			loginPage.getPasswordInput().sendKeys("12345");
			loginPage.getLoginButton().click();
			navPage.getAdminButton().click();
			navPage.getCitiesLink().click();
			citiesPage.getNewItemButton().click();
			citiesPage.getNewItemInput().sendKeys("Praha");
			citiesPage.getSaveButtonFromDialog().click();
			citiesPage.waitForMessageDialogToBeVisible();
			Assert.assertEquals(citiesPage.getMessageDialogText().getText(), "Saved successfully", "ERROR: Incorrect message.");
		}
		
//		@Test
//		public void EditCity() {
//			navPage.getLoginButton().click();
//			loginPage.getEmailInput().sendKeys("admin@admin.com");
//			loginPage.getPasswordInput().sendKeys("12345");
//			loginPage.getLoginButton().click();
//			navPage.getAdminButton().click();
//			navPage.getCitiesLink().click();
//			citiesPage.getSearchInput().sendKeys("Praha");
//			citiesPage.waitForNumberOfRows(1);
//			citiesPage.getEditButton(1);
//			
//			citiesPage.getSaveButtonFromDialog().click();
//			
//			Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), "Praha", "ERROR");
//		}
		
		@Test
		public void SearchCity() {
			loginPage.getEmailInput().sendKeys("admin@admin.com");
			loginPage.getPasswordInput().sendKeys("12345");
			loginPage.getLoginButton().click();
			navPage.getAdminButton().click();
			navPage.getCitiesLink().click();
			citiesPage.getSearchInput().sendKeys("Praha");
			citiesPage.waitForNumberOfRows(1);
			Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), "Praha", "ERROR");
		}
		
		@Test
		public void DeleteCity() {
			
		}
}
