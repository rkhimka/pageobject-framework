package com.app.helpers;

import com.app.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactsPage extends BaseHelper {
    private List<Contact> contactsCache = null;

    public ContactsPage(WebDriver wd) {
        super(wd);
    }

    public int contactsCount() {
        return wd.findElements(By.xpath("//tr[@name='entry']")).size();
    }

    public void create(Contact contactData) {
        initContactCreation();
        fillContactInformation(contactData, true);
        submitContactCreation();
        contactsCache = null;
        returnToContactsPage();
    }

    public void delete(int contactIndex) {
        selectContact(contactIndex);
        submitContactDeletion();
        acceptAlert();
        contactsCache = null;
        returnToContactsPage();
    }

    public void edit(int contactIndex, Contact modifiedContactData) {
        initContactEditing(contactIndex);
        fillContactInformation(modifiedContactData, false);
        submitContactEditing();
        contactsCache = null;
        returnToContactsPage();
    }

    public List<Contact> getAll() {
        if (contactsCache == null) {
            contactsCache = new ArrayList<>();
            List<WebElement> tableRows = wd.findElements(By.xpath("//tr[@name='entry']"));
            for (WebElement row : tableRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                String lName = cells.get(1).getText();
                String fName = cells.get(2).getText();
                String email = cells.get(4).getText();
                String phones = cells.get(5).getText();
                contactsCache.add(new Contact().firstName(fName)
                        .lastName(lName)
                        .email(email)
                        .allPhones(phones));
            }
        }
        return contactsCache;
    }

    public void initContactCreation() {
        click(By.xpath("//a[text()='add new']"));
    }

    public void initContactEditing(int contaxtIndex) {
        click(By.xpath(String.format("(//img[@title='Edit']/parent::a)[%s]", contaxtIndex + 1)));
    }

    public boolean isAnyContactCreated() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

    public void fillContactInformation(Contact contact, boolean isCreation) {
        type(By.xpath("//input[@name='firstname']"), contact.firstName());
        type(By.xpath("//input[@name='lastname']"), contact.lastName());
        type(By.xpath("//input[@name='nickname']"), contact.nickName());
        type(By.xpath("//input[@name='home']"), contact.homePhone());
        type(By.xpath("//input[@name='mobile']"), contact.mobilePhone());
        type(By.xpath("//input[@name='work']"), contact.workPhone());
        type(By.xpath("//input[@name='company']"), contact.company());
        type(By.xpath("//input[@name='email']"), contact.email());
        if (isCreation) {
            select(wd.findElement(By.xpath("//select[@name='new_group']")), contact.groupName());
        } else {
            Assert.assertFalse(isElementPresent(By.xpath("//select[@name='new_group']")));
        }
    }

    public void returnToContactsPage() {
        click(By.xpath("//a[text()='home']"));
    }

    public void selectContact(int contactIndex) {
        List<WebElement> contacts = wd.findElements(By.xpath("//input[@name='selected[]']"));
        WebElement contact = contacts.get(contactIndex);
        if (!contact.isSelected()) {
            contact.click();
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
