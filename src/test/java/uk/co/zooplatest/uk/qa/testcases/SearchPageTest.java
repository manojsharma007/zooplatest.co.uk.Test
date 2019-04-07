package uk.co.zooplatest.uk.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.zooplatest.qa.base.TestBase;
import uk.co.zooplatest.qa.pages.HomePage;
import uk.co.zooplatest.qa.pages.SearchPage;

public class SearchPageTest extends TestBase {
	HomePage homePage;
	SearchPage searchPage;

	@BeforeMethod
	public void SetUp() {
		initialization();
		homePage = new HomePage();
		searchPage = new SearchPage();
		homePage.enterSearchTextBoxandClick(prop.getProperty("searchText"));

	}

	@Test(priority = 1)
	public void getAllPriceValueTest() {
		searchPage.printPriceListWithDescendingOrder();

	}
	@Test(priority = 2)
	public void clickOnFifthPriceTest() throws InterruptedException {
		searchPage.clickOnFifthPrice();

	}
	@Test(priority = 3)
	public void getAgentDetailsTest() throws InterruptedException {
		searchPage.clickOnFifthPrice();
		Thread.sleep(3000);
		searchPage.printAgentDetails();

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
