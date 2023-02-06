package com.travello.tests.contacts;

import com.travello.models.ContactData;
import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

public class EditContactTest extends BaseTest {

    @Test
    public void editContactTest() {
        app.contactsPage().selectFirstContact();
        app.contactsPage().initContactEditing();
        app.contactsPage().fillContactInformation(new ContactData("John", "Doe", "jDoe",
                "New Company", "new@mail.com", null), false);
        app.contactsPage().submitContactEditing();
        app.navigateTo().homePage();
    }
}