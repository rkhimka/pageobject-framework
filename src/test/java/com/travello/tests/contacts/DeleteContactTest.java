package com.travello.tests.contacts;

import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

public class DeleteContactTest  extends BaseTest {

    @Test
    public void deleteContactSuccessTest() {
        app.contactsPage().selectFirstContact();
        app.contactsPage().initContactEditing();
        app.contactsPage().submitContactDeletion();
        app.navigateTo().homePage();
    }
}