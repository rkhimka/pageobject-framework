package com.travello.tests.contacts;

import com.travello.models.ContactData;
import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

public class EditContactTest extends BaseTest {

    @Test
    public void editContactTest() {
        app.getContactsPage().selectFirstContact();
        app.getContactsPage().initContactEditing();
        app.getContactsPage().fillContactInformation(new ContactData("John", "Doe", "jDoe",
                "New Company", "new@mail.com", null), false);
        app.getContactsPage().submitContactEditing();
        app.getNavigation().followHomePage();
    }
}