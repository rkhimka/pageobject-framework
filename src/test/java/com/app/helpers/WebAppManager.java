package com.app.helpers;

import com.app.factory.DriverFactory;
import com.app.factory.UrlFactory;
import com.app.models.Login;
import com.app.utils.ResourceUtil;
import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Properties;

@Data
public class WebAppManager {
    public WebDriver wd;
    private final Properties properties;
    private final DriverFactory driverFactory;
    private Navigation navigation;
    private GroupsPage groupsPage;
    private ContactsPage contactsPage;
    private Session session;
    private UrlFactory urlFactory;

    //TODO: fetch isRemote value from env variables
    public WebAppManager(boolean isRemote, String browser, String env, String testCredentialsFileName) {
        driverFactory = new DriverFactory(isRemote, browser);
        urlFactory = new UrlFactory(env);
        properties = ResourceUtil.getProperties(testCredentialsFileName);
    }

    public Navigation navigateTo() {
        return navigation;
    }

    public GroupsPage groupsPage() {
        return groupsPage;
    }

    public ContactsPage contactsPage() {
        return contactsPage;
    }

    public void init() {
        wd = driverFactory.getDriver();
        wd.manage().window().maximize();
        //TODO: set seconds as constant variable IMPLICIT_WAIT_SHORT
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wd.get(urlFactory.getUrl());
        groupsPage = new GroupsPage(wd);
        contactsPage = new ContactsPage(wd);
        navigation = new Navigation(wd);
        session = new Session(wd);
        session.login(new Login(properties.getProperty("admin.login"),
                properties.getProperty("admin.password")));
    }

    public void stop() {
        wd.quit();
    }

}
