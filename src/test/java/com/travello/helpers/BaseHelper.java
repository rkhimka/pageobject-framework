package com.travello.helpers;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class BaseHelper {
    protected WebDriver wd;

    protected void click(By element) {
        wd.findElement(element).click();
    }

    protected void type(By element, String text) {
        wd.findElement(element).sendKeys(text);
    }
}
