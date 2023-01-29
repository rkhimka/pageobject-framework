package com.travello.helpers;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Data
public class WebAppManager {
    public WebDriver wd;
    private WebNavigation navigation;
    private GroupsPage groupsPage;
    private Session session;

    public void init() {
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.get("http://localhost/addressbook/");
        groupsPage = new GroupsPage(wd);
        navigation = new WebNavigation(wd);
        session = new Session(wd);
    }

    public void stop() {
        wd.quit();
    }



}
