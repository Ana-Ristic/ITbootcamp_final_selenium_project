package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void waitForPopUpToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[contains(@class, 'v-snack__content')]")));
	}
	
	public WebElement getTextFromPopUpDialog() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-snack__content')]/ul/li"));
	}
	
	public WebElement getCloseButton() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Close')]"));
	}
	public void waitForVerifyYourAccountPopUpToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.className("dlgVerifyAccount")));
	}
	public WebElement getTextFromVerifyAccountPopUpDialog() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]"));
	}
	public WebElement getVerifyAccountCloseButton() {
		return driver.findElement(By.className("btnClose"));
	}	
}
