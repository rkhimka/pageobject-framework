package com.travello.helpers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor
@AllArgsConstructor
public class WebNavigation {
    private WebDriver wd;

    public void followGroupsPage() {
        wd.findElement(By.xpath("//a[text()='groups']")).click();
    }
}
