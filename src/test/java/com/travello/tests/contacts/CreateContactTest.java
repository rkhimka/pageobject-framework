package com.travello.tests.contacts;

import com.travello.models.ContactData;
import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

public class CreateContactTest extends BaseTest {

    @Test
    public void createContactTest() {
        app.getContactsPage().initContactCreation();
        app.getContactsPage().fillContactInformation(new ContactData("Roma", "Test", "rTest",
                "Test Company", "test@mail.com", "My test group"), true);
        app.getContactsPage().submitContactCreation();
        app.getNavigation().followHomePage();
    }
}
