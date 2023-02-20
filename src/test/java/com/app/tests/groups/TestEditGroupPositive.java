package com.app.tests.groups;

import com.app.models.Group;
import com.app.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.app.data.constants.TestFeatures.GROUPS;
import static com.app.data.constants.TestTypes.*;
import static com.app.data.testdata.GroupData.getGroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestEditGroupPositive extends BaseTest {

    @BeforeMethod
    public void preconditionStep() {
        app.navigateTo().groupsPage();
        if (!app.groupsPage().isAnyGroupCreated()) {
            app.groupsPage().create(getGroupData());
        }
    }

    @Test(groups = {GROUPS})
    public void editGroupTest() {
        Group modifiedData = getGroupData();

        app.navigateTo().groupsPage();
        List<Group> before = app.groupsPage().getAll();
        int lastGroupIndex = before.size() - 1;
        Group groupToModify = before.get(lastGroupIndex);
        app.groupsPage().edit(lastGroupIndex, modifiedData);

        assertThat(app.groupsPage().groupsCount(), equalTo(before.size()));
        List<Group> after = app.groupsPage().getAll();

        assertThat(after.contains(groupToModify), is(false));
        assertThat(after.contains(modifiedData), is(true));
    }
}
