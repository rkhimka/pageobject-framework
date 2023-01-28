package com.travello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static constants.Constant.Timeouts.IMPLICIT_WAIT_TIME;

public class Search {

    @Test
    public void testOne() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
        driver.get("https://www.backpackerdeals.com/");
        driver.findElement(By.xpath(""));
    }
}
