package com.travello.helpers;

import com.travello.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactsPage extends BaseHelper {

    public ContactsPage(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.xpath("//a[text()='add new']"));
    }

    public void initContactEditing() {
        click(By.xpath("(//img[@title='Edit'])[1]"));
    }

    public void fillContactInformation(ContactData contact, boolean isCreation) {
        type(By.xpath("//input[@name='firstname']"), contact.getFirstName());
        type(By.xpath("//input[@name='lastname']"), contact.getLastName());
        type(By.xpath("//input[@name='nickname']"), contact.getNickName());
        type(By.xpath("//input[@name='company']"), contact.getCompany());
        type(By.xpath("//input[@name='email']"), contact.getEmail());
        if (isCreation) {
            select(wd.findElement(By.xpath("//select[@name='new_group']")), contact.getGroupName());
        } else {
            Assert.assertFalse(isElementPresent(By.xpath("//select[@name='new_group']")));
        }
    }

    public void selectFirstContact() {
        if (!wd.findElement(By.xpath("(//input[@name='selected[]'])[1]")).isSelected()) {
            click(By.xpath("(//input[@name='selected[]'])[1]"));
        }
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@value='Enter'])[2]"));
    }

    public void submitContactEditing() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }
}
