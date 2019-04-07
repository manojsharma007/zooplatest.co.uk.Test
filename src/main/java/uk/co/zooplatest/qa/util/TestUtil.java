package uk.co.zooplatest.qa.util;

import org.openqa.selenium.JavascriptExecutor;

import uk.co.zooplatest.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICITY_WAIT =20;
	
	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		
	}

}
