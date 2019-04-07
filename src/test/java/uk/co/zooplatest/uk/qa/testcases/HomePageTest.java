package uk.co.zooplatest.uk.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.zooplatest.qa.base.TestBase;
import uk.co.zooplatest.qa.pages.HomePage;

public class HomePageTest extends TestBase

{
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		homePage = new HomePage();

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.varifyHomePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents",
				"Home page title not metched");
	}
	@Test(priority = 2)
	public void enterSearchTextTest() throws InterruptedException {
		String searchText = prop.getProperty("searchText");
		homePage.enterSearchTextBoxandClick(searchText);
		//Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
