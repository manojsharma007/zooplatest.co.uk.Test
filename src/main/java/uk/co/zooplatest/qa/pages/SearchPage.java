package uk.co.zooplatest.qa.pages;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.zooplatest.qa.util.TestUtil;

import uk.co.zooplatest.qa.base.TestBase;

public class SearchPage extends TestBase {

	@FindBy(xpath = "//ul[@class='listing-results clearfix js-gtm-list']//li//descendant::div//a[@class='listing-results-price text-price']")
	List<WebElement> priceListUI;

	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//h4")
	WebElement agentName;

	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//p")
	WebElement agentPhoneNumber;

	// Initizing the page Objects
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 */
	public void printPriceListWithDescendingOrder() {
		ArrayList<String> priceList =new ArrayList<String>();
		List<WebElement> list = priceListUI;
		System.out.println("Before sorting the array");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			priceList.add(list.get(i).getText());
		}
		/* Sorting in decreasing order */
		System.out.println("After sorting the array");
		Collections.sort(priceList);
		System.out.println("Total number :" + list.size());
		for (int i = 0; i < priceList.size(); i++) {
			System.out.println(priceList.get(i));
		}
		//return priceList;
	}

	public SearchPage clickOnFifthPrice() throws InterruptedException {
		List<WebElement> list = priceListUI;
	    TestUtil.scrollDown();
	    Thread.sleep(2000);
		for (int i = 0; i < list.size(); i++) {
			if (i == 4) {
				list.get(i).click();
				break;
			}
		}
		return new SearchPage();

	}

	public void printAgentDetails() {
		System.out.println("Agent Name is:" + agentName.getText());
		System.out.println("Phone Number is :" + agentPhoneNumber.getText());

	}

	public String agentName() {
		return agentName.getText();

	}

	public void clickOnAgentName() {
		agentName.click();

	}
}
