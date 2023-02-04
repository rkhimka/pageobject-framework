package com.travello.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends BaseHelper{

    public Navigation(WebDriver wd) {
        super(wd);
    }

    public void followGroupsPage() {
        click(By.xpath("//a[text()='groups']"));
    }
}
