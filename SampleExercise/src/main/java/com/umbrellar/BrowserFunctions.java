package com.umbrellar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

@SuppressWarnings("unused")
public class BrowserFunctions {
	protected static WebDriver driver;

	@SuppressWarnings("deprecation")
	@Parameters({ "browser", "baseURL" })
	@BeforeClass
	public void openBrowser(String browser, String baseURL) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "d:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			driver = new InternetExplorerDriver(caps);
		}

		else {
			System.out.println("Browser not supported or incoorect browser name, running your tests in firefox");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@AfterClass
	public void afterClass() {

	}

}
