package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}
	public WebElement getNewItemInput() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}
	public WebElement getMessageDialogText() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Saved successfully')]"));
	}
	
	public void waitForMessageDialogToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//*[contains(text(), 'Saved successfully')]")));
	}
	
	public void waitForEditDialogtoBeVisible() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.className("dlgNewEditItem")));
	}
	public void waitForDeletePopUp() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.className("body-1")));
	}
	public WebElement getSaveButtonFromDialog() {
		return driver.findElement(By.className("btnSave"));
	}
	public WebElement getDeleteButtonFromDialog() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-card__actions')/button[2]"));
	}
	public void waitForNumberOfRows(int rowNumber) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rowNumber));
	}
	public WebElement getTableCell(int rowNumber, int columnNumber) {
		return driver.findElement(By.xpath("//tbody/tr["+ rowNumber + "]/td[" + columnNumber + "]"));
	}
	public WebElement getEditButton(int rowNumber) {
		return driver.findElement(By.xpath("//tbody/tr["+ rowNumber + "]//button[@id = 'edit']"));
	}
	
	public WebElement getDeleteButtonFromRow(int rowNumber) {
		return driver.findElement(By.xpath("//tbody/tr["+ rowNumber + "]//div/button[2]"));
	}

}
