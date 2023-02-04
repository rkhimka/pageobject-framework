package com.travello.helpers;

import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@Data
public class WebAppManager {
    //TODO: fetch isRemote value from env variables
    private final DriverFactory driverFactory;
    public WebDriver wd;
    private Navigation navigation;
    private GroupsPage groupsPage;
    private Session session;
    private String url;

    public WebAppManager(boolean isRemote, String browser, String url) {
        driverFactory = new DriverFactory(isRemote, browser);
        this.url = url;
    }

    public void init() {
        wd = driverFactory.getDriver();
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        wd.manage().window().maximize();
        //TODO: set seconds as constant variable IMPLICIT_WAIT_SHORT
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.get(url);
        groupsPage = new GroupsPage(wd);
        navigation = new Navigation(wd);
        session = new Session(wd);
    }

    public void stop() {
        wd.quit();
    }

    public DriverFactory getDriverFactory() {
        return driverFactory;
    }
}
