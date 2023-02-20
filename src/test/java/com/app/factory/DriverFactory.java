package com.app.factory;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

@AllArgsConstructor
public class DriverFactory {
    protected boolean isRemote;
    protected String browser;

    public WebDriver getDriver() {
        if (!isRemote) {
            return getLocalDriver();
        } else {
            return getRemoteDriver();
        }
    }

    private WebDriver getLocalDriver() {
        WebDriver wd = null;
        if (browser.equals(Browser.CHROME.browserName())) {
            wd = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())) {
            wd = new FirefoxDriver();
        }
        return wd;
    }

    private WebDriver getRemoteDriver() {
        return null;
    }
}
