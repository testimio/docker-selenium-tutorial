package io.testim;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTest {

	private static String GRID_URL;
	private WebDriver driver;

	@BeforeSuite
	@Parameters(value = { "gridUrl" })
	public void beforeSuite(String gridUrl) {
		GRID_URL = gridUrl;
	}

	@Parameters(value = { "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		this.driver = new RemoteWebDriver(new URL(GRID_URL), capabilities);
	}

	@Test
	public void testExampleCom() {
		driver.get("http://www.example.com");
	}

	@Test
	public void testToDoMVC() {
		this.driver.get("http://www.todomvc.com");
	}

}
