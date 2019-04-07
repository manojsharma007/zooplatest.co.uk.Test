package uk.co.zooplatest.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uk.co.zooplatest.qa.base.TestBase;

public class AgentPage extends TestBase{
	
	@FindBy(xpath = "//h1//b")
	WebElement agentName;
	
	// Initizing the page Objects
		public AgentPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String getAgentName() {
			System.out.println(agentName.getText());
			return agentName.getText();

		}

}
