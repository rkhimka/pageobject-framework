package com.app.helpers;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@AllArgsConstructor
public class BaseHelper {
    protected WebDriver wd;

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        String existingVal;
        if (text != null) {
            existingVal = element.getAttribute("value");
            if (!text.equals(existingVal)) {
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    public void select(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
