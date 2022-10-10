package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getHomeLink() {
		return driver.findElement(By.className("btnHome"));
	}
	public WebElement getAboutLink() {
		return driver.findElement(By.className("btnAbout"));
	}
	public WebElement getMyProfileLink() {
		return driver.findElement(By.className("btnProfile"));
	}
	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}
	public WebElement getCitiesLink() {
		return driver.findElement(By.className("btnAdminCities"));
	}
	public WebElement getUsersLink() {
		return driver.findElement(By.className("btnAdminUsers"));
	}
	public WebElement getSignupButton() {
		return driver.findElement(By.className("v-toolbar__items")).findElement(By.xpath("//a[4]"));
	}
	public WebElement getLoginButton() {
		return driver.findElement(By.className("btnLogin"));
	}
	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}
	public WebElement getLanguageButton() {
		return driver.findElement(By.className("btnLocaleActivation"));
	}
	public WebElement getENLanguageButton() {
		return driver.findElement(By.id("list-item-73"));
	}
	public WebElement getESLanguageButton() {
		return driver.findElement(By.className("btnES"));
	}
	public WebElement getFRLanguageButton() {
		return driver.findElement(By.className("btnFR"));
	}
	public WebElement getCNLanguageButton() {
		return driver.findElement(By.className("btnCN"));
	}
	public WebElement getHeader() {
		return driver.findElement(By.tagName("h1"));
	}
	
	

}
