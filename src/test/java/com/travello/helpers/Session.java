package com.travello.helpers;

import com.travello.models.LoginData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
@Getter
public class Session {
    private WebDriver wd;

    public void loginUser(LoginData credentials) {
        WebElement loginField = wd.findElement(By.xpath("//input[@name='user']"));
        loginField.click();
        loginField.sendKeys(credentials.getLogin());
        WebElement passwordField = wd.findElement(By.xpath("//input[@name='pass']"));
        passwordField.sendKeys(credentials.getPassword());
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }
}
