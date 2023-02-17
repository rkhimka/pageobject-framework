package com.app.tests.groups;

import com.app.models.Group;
import com.app.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.app.data.testdata.GroupData.getGroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteGroupTest extends BaseTest {

    @BeforeMethod
    public void preconditionStep() {
        app.navigateTo().groupsPage();
        if (!app.groupsPage().isAnyGroupCreated()) {
            app.groupsPage().create(getGroupData());
        }
    }

    @Test
    public void deleteGroupSuccessTest() {
        app.navigateTo().groupsPage();
        List<Group> before = app.groupsPage().getAll();
        int lastGroupIndex = before.size() - 1;
        Group groupToDelete = before.get(lastGroupIndex);
        app.groupsPage().delete(lastGroupIndex);

        assertThat(app.groupsPage().groupsCount(), equalTo(before.size() - 1));
        List<Group> after = app.groupsPage().getAll();
        assertThat(after.contains(groupToDelete), is(false));
    }
}
