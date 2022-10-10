package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
		@Test 
		public void SetLocaleToES() {
			navPage.getLanguageButton().click();
			navPage.getESLanguageButton().click();
			Assert.assertEquals(navPage.getHeader().getText(), "Página de aterrizaje",
					"ERROR: Incorrect Title.");
		}
		
		@Test 
		public void SetLocaleToEN() {
			navPage.getLanguageButton().click();
			navPage.getENLanguageButton().click();
			Assert.assertEquals(navPage.getHeader().getText(), "Landing",
					"ERROR: Incorrect Title.");
		}
		
		@Test 
		public void SetLocaleToFR() {
			navPage.getLanguageButton().click();
			navPage.getFRLanguageButton().click();
			Assert.assertEquals(navPage.getHeader().getText(), "Page d'atterrissage",
					"ERROR: Incorrect Title.");
		}
		
		@Test 
		public void SetLocaleToCN() {
			navPage.getLanguageButton().click();
			navPage.getCNLanguageButton().click();
			Assert.assertEquals(navPage.getHeader().getText(), "首页",
					"ERROR: Incorrect Title.");
		}

}
