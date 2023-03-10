package com.app.tests.contacts;

import com.app.models.Contact;
import com.app.models.Group;
import com.app.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.app.data.constants.TestFeatures.CONTACTS;
import static com.app.data.constants.TestTypes.POSITIVE;
import static com.app.data.constants.TestTypes.SMOKE;
import static com.app.data.testdata.ContactData.getContactData;
import static com.app.data.testdata.GroupData.getGroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestEditContactPositive extends BaseTest {
    private final int FIRST = 0;
    Contact testContact;

    @BeforeMethod
    public void preconditionStep() {
        Group testGroup;
        if (!app.contactsPage().isAnyContactCreated()) {
            app.navigateTo().groupsPage();
            if (!app.groupsPage().isAnyGroupCreated()) {
                testGroup = getGroupData();
                app.groupsPage().create(testGroup);
            } else {
                testGroup = app.groupsPage().getAll().get(FIRST);
            }
            app.navigateTo().homePage();
            testContact = getContactData().groupName(testGroup.title());
            app.contactsPage().create(testContact);
        } else {
            testContact = app.contactsPage().getAll().get(FIRST);
        }
    }

    @Test(groups = {POSITIVE, CONTACTS})
    public void editContactTest() {
        Contact modifiedData = getContactData();

        List<Contact> before = app.contactsPage().getAll();
        app.contactsPage().edit(FIRST, modifiedData);

        assertThat(app.contactsPage().contactsCount(), equalTo(before.size()));
        List<Contact> after = app.contactsPage().getAll();
        assertThat(after.contains(testContact), is(false));
        assertThat(after.contains(modifiedData), is(true));
    }
}