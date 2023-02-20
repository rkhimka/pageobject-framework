package com.app.tests;

import com.app.helpers.WebAppManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static final WebAppManager app = new WebAppManager(false,
            System.getProperty("browser", Browser.CHROME.browserName()),
            System.getProperty("env","dev"),
            System.getProperty("testcredentials","credentials.properties"));

    @BeforeSuite
    public void setup() {
        app.init();
    }

    @AfterSuite
    public void teardown() {
        app.stop();
    }

}
