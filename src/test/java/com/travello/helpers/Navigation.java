package com.travello.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends BaseHelper {

    public Navigation(WebDriver wd) {
        super(wd);
    }

    public void groupsPage() {
        if (isElementPresent(By.xpath("//h1[text()='Groups']"))
                && isElementPresent(By.xpath("(//input[@value='New group'])[1]"))) {
            return;
        }
        click(By.xpath("//a[text()='groups']"));
    }

    public void homePage() {
        if (isElementPresent(By.xpath("//table[@id='maintable']"))) {
            return;
        }
        click(By.xpath("//a[text()='home']"));
    }
}
