package uk.co.zooplatest.uk.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.zooplatest.qa.base.TestBase;
import uk.co.zooplatest.qa.pages.AgentPage;
import uk.co.zooplatest.qa.pages.HomePage;
import uk.co.zooplatest.qa.pages.SearchPage;

public class AgentPageTest extends TestBase {
	HomePage homePage;
	SearchPage searchPage;
	AgentPage agentPage;

	@BeforeMethod
	public void SetUp() {
		initialization();
		homePage = new HomePage();
		searchPage = new SearchPage();
		agentPage = new AgentPage();
		homePage.enterSearchTextBoxandClick(prop.getProperty("searchText"));

	}

	@Test(priority = 1)
	public void getAgentDetailsTest() throws InterruptedException {
		searchPage.printPriceListWithDescendingOrder();
		Thread.sleep(10000);
		searchPage.clickOnFifthPrice();
		String agentNameSearhPage = searchPage.agentName();

		Thread.sleep(2000);
		searchPage.clickOnAgentName();
		Thread.sleep(3000);
		String agentName = agentPage.getAgentName();
		Assert.assertEquals(agentNameSearhPage, agentName, "Agent Name does not match");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
