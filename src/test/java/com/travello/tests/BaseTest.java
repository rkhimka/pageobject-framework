package com.travello.tests;

import com.travello.helpers.WebAppManager;
import com.travello.models.LoginData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static final WebAppManager app = new WebAppManager(false,
            "chrome",
            "http://localhost/addressbook/");

    @BeforeSuite
    public void setup() {
        app.init();
        app.getSession().login(new LoginData("admin", "secret"));
    }

    @AfterSuite
    public void teardown() {
        app.stop();
    }

}
