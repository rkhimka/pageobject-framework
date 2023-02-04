package com.travello.helpers;

import com.travello.models.LoginData;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class Session extends BaseHelper {

    public Session(WebDriver wd) {
        super(wd);
    }

    public void login(LoginData credentials) {
        type(By.xpath("//input[@name='user']"), credentials.getLogin());
        type(By.xpath("//input[@name='pass']"), credentials.getPassword());
        click(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
    }

}
