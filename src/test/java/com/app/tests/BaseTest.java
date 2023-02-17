package com.app.tests;

import com.app.helpers.WebAppManager;
import com.app.models.Login;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static final WebAppManager app = new WebAppManager(false,
            "chrome",
            "http://localhost/addressbook/");

    @BeforeSuite
    public void setup() {
        app.init();
        app.getSession().login(new Login("admin", "secret"));
    }

    @AfterSuite
    public void teardown() {
        app.stop();
    }

}
