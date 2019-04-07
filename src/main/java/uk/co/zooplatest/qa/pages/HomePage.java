package uk.co.zooplatest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import uk.co.zooplatest.qa.base.TestBase;

public class HomePage extends TestBase{
	 @FindBy(name="q")
	 WebElement searchInputText;
	 
	 @FindBy(id="search-submit")
	 WebElement searchButton;
	 
	 //Initizing the page Objects
	 public HomePage() {
		 PageFactory.initElements(driver, this);
	 }
	 
     // Actions
 	 
	 public String varifyHomePageTitle() {
		 return driver.getTitle();
		
	}
	 public SearchPage enterSearchTextBoxandClick(String searchText) {
		 searchInputText.sendKeys(searchText);
		 searchButton.click();	
		 return new SearchPage();
		 
	 }


}
