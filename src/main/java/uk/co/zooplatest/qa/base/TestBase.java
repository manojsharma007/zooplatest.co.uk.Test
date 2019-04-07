package uk.co.zooplatest.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import uk.co.zooplatest.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Manoj\\eclipse-workspace\\uk.co.zooplatest\\src\\main\\java\\uk\\co\\zooplatest\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (Exception e) {

		}

	}

	public static void initialization() {
		String browerName = prop.getProperty("brower");
		if (browerName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Work\\AutoMation\\WebDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browerName.equals("FF")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Work\\AutoMation\\WebDriver\\chromedriver_win32\\gechodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
}
