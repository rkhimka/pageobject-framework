package com.travello.tests.contacts;

import com.travello.models.ContactData;
import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

public class CreateContactTest extends BaseTest {

    @Test
    public void createContactTest() {
        app.contactsPage().initContactCreation();
        app.contactsPage().fillContactInformation(new ContactData("Roma", "Test", "rTest",
                "Test Company", "test@mail.com", "My test group"), true);
        app.contactsPage().submitContactCreation();
        app.navigateTo().homePage();
    }
}
