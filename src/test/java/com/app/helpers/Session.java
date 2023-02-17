package com.app.helpers;

import com.app.models.Login;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class Session extends BaseHelper {

    public Session(WebDriver wd) {
        super(wd);
    }

    public void login(Login credentials) {
        type(By.xpath("//input[@name='user']"), credentials.getLogin());
        type(By.xpath("//input[@name='pass']"), credentials.getPassword());
        click(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
    }

}
