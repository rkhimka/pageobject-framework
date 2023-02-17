package com.app.helpers;

import com.app.driver.DriverFactory;
import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@Data
public class WebAppManager {
    //TODO: fetch isRemote value from env variables
    private final DriverFactory driverFactory;
    public WebDriver wd;
    private Navigation navigation;

    public Navigation navigateTo() {
        return navigation;
    }

    public GroupsPage groupsPage() {
        return groupsPage;
    }

    public ContactsPage contactsPage() {
        return contactsPage;
    }

    private GroupsPage groupsPage;
    private ContactsPage contactsPage;
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
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wd.get(url);
        groupsPage = new GroupsPage(wd);
        contactsPage = new ContactsPage(wd);
        navigation = new Navigation(wd);
        session = new Session(wd);
    }

    public void stop() {
        wd.quit();
    }

}
