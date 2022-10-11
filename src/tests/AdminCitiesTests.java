package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
	@Test
	public void VisitsTheAdminCitiesPageAndListCities(){
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/cities", "ERROR: Incorrect URL.");
	}
	
	@Test
	public void ChecksInputTypesForCreateEditNewCity(){
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditDialogtoBeVisible();
		Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"),"text", "ERROR: Incorrect attribut value.");
	}
	
	@Test
	public void CreateNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.getNewItemInput().sendKeys("Sam's Town");
		citiesPage.getSaveButtonFromDialog().click();
		citiesPage.waitForMessageDialogToBeVisible();
		Assert.assertTrue(citiesPage.getMessageDialogText().getText().contains(
				"Saved successfully"), "ERROR: Incorrect message.");
	} 
	
	@Test
	public void EditCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Tom's Town");
		citiesPage.waitForNumberOfRows(1);
		citiesPage.getEditButton(1).click();
		citiesPage.getNewItemInput().sendKeys("Sam's Town");
		citiesPage.getSaveButtonFromDialog().click();
		Assert.assertTrue(citiesPage.getMessageDialogText().getText().contains(
				"Saved successfully"), "ERROR: Incorrect message.");
	}
	
	@Test
	public void SearchCity(){
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Sam's Town");
		citiesPage.waitForNumberOfRows(1);
		Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), "Sam's Town", "ERROR: Incorrect City Name.");
	}
	
	@Test
	public void DeleteCity(){
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Sam's Town");
		citiesPage.waitForNumberOfRows(1);
		Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), "Sam's Town", "ERROR: Incorrect City Name.");
		citiesPage.getDeleteButtonFromRow(1).click();
		citiesPage.waitForDeletePopUp();
		citiesPage.getDeleteButtonFromDialog().click();
		citiesPage.waitForMessageDialogToBeVisible();
		Assert.assertTrue(citiesPage.getMessageDialogText().getText().contains(
				"Deleted successfully"), "ERROR: Incorrect message.");
		
		
	}
	
}
