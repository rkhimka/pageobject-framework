package com.travello.tests;

import com.travello.helpers.WebAppManager;
import com.travello.models.LoginData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected final WebAppManager app = new WebAppManager(false, "chrome",
            "http://localhost/addressbook/");

    @BeforeTest
    public void setup() {
        app.init();
        app.getSession().login(new LoginData("admin", "secret"));
    }

    @AfterTest
    public void teardown() {
        app.stop();
    }

}
