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
//		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/a[4]"));
		return driver.findElement(By.className("v-toolbar__items")).findElement(By.xpath("//a[4]"));
	}
	public WebElement getLoginButton() {
//		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/a[3]"));
		return driver.findElement(By.className("v-toolbar__items")).findElement(By.xpath("//a[3]"));
	}
	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}
	public WebElement getLanguageButton() {
		return driver.findElement(By.className("btnLocaleActivation"));
	}
	public WebElement getEnLanguageButton() {
		return driver.findElement(By.xpath("//*[@role = 'menu']/div/div[1]"));
	}
	public WebElement getEsLanguageButton() {
		return driver.findElement(By.xpath("//*[@role = 'menu']/div/div[2]"));
	}
	public WebElement getFrLanguageButton() {
		return driver.findElement(By.xpath("//*[@role = 'menu']/div/div[3]"));
	}
	public WebElement getCnLanguageButton() {
		return driver.findElement(By.xpath("//*[@role = 'menu']/div/div[4]"));
	}
	
	

}
