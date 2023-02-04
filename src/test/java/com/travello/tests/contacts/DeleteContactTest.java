package com.travello.tests.contacts;

import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

public class DeleteContactTest  extends BaseTest {

    @Test
    public void deleteContactSuccessTest() {
        app.getContactsPage().selectFirstContact();
        app.getContactsPage().initContactEditing();
        app.getContactsPage().submitContactDeletion();
        app.getNavigation().followHomePage();
    }
}