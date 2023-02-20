package com.app.tests.contacts;

import com.app.models.Contact;
import com.app.models.Group;
import com.app.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static com.app.data.constants.TestFeatures.CONTACTS;
import static com.app.data.constants.TestTypes.POSITIVE;
import static com.app.data.constants.TestTypes.SMOKE;
import static com.app.data.testdata.ContactData.getContactData;
import static com.app.data.testdata.GroupData.getGroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCreateContactPositive extends BaseTest {
    private final int FIRST = 0;
    private Group testGroup;

    @BeforeMethod
    public void preconditionStep() {
        app.navigateTo().groupsPage();
        if (!app.groupsPage().isAnyGroupCreated()) {
            testGroup = getGroupData();
            app.groupsPage().create(testGroup);
        } else {
            testGroup = app.groupsPage().getAll().get(FIRST);
        }
    }

    @Test(groups = {SMOKE, POSITIVE, CONTACTS})
    public void createContactTest() {
        Contact newContact = getContactData().groupName(testGroup.title());

        app.getNavigation().homePage();
        List<Contact> before = app.contactsPage().getAll();
        app.getContactsPage().create(newContact);

        assertThat(app.contactsPage().contactsCount(), equalTo(before.size() + 1));
        before.add(newContact);
        List<Contact> after = app.contactsPage().getAll();
        before.sort(Comparator.comparing(Contact::firstName));
        after.sort(Comparator.comparing(Contact::firstName));

        assertThat(after.contains(newContact), is(true));
        assertThat(before, equalTo(after));
    }
}
