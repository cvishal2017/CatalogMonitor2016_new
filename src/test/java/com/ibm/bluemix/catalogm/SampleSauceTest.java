package com.ibm.bluemix.catalogm;

import com.saucelabs.common.SauceOnDemandAuthentication;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucelabs.junit.SauceOnDemandTestWatcher;

import java.net.URL;

import static org.junit.Assert.*;

import com.saucelabs.common.SauceOnDemandSessionIdProvider;


public class SampleSauceTest implements SauceOnDemandSessionIdProvider {

    public String username = System.getenv("SAUCE_USERNAME");
    public String accesskey = System.getenv("SAUCE_ACCESS_KEY");
    public String appurl = System.getenv("APP_URL");

    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(username, accesskey);

    /**
     * JUnit Rule which will mark the Sauce Job as passed/failed when the test succeeds or fails.
     */
    @Rule
    public SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);

    private String browser;
    private String os;
    private String version;
    private String deviceName;
    private String deviceOrientation;
    private String sessionId;

    private WebDriver driver;
    private DesiredCapabilities capabilities;
    
    
    @Before
    public void setUp() throws Exception {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(CapabilityType.VERSION, "43.0");
        if (deviceName != null) capabilities.setCapability("deviceName", deviceName);
        if (deviceOrientation != null) capabilities.setCapability("device-orientation", deviceOrientation);

        capabilities.setCapability(CapabilityType.PLATFORM, "Windows 7");

    }

    @Test
    public void verifyBrowserTitle() throws Exception {
    	
    	capabilities.setCapability("name", "Catalog Monitor Unitlity Test - Verify Application Page");
    	
    	this.driver = new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() +
                        "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();

        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", this.sessionId, "verifyBrowserTitle");
        System.out.println(message);
        
                
        driver.get(appurl);
        Thread.sleep(30000);
        for (int i = 0 ; i < 10000 ; i++) {
        	
        }
	    System.out.println("title of page is: " + driver.getTitle());
	    
	    assertEquals("Verify Page title", "IBM w3id", driver.getTitle());

    }
    
    

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Override
    public String getSessionId() {
        return sessionId;
    }
}

