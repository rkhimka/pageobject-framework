package com.app.tests.groups;

import com.app.models.Group;
import com.app.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.app.data.constants.TestFeatures.GROUPS;
import static com.app.data.constants.TestTypes.POSITIVE;
import static com.app.data.constants.TestTypes.SMOKE;
import static com.app.data.testdata.GroupData.getGroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCreateGroupPositive extends BaseTest {

    @Test(groups = {SMOKE, POSITIVE, GROUPS})
    public void createGroupTest() {
        Group newGroup = getGroupData();

        app.navigateTo().groupsPage();
        List<Group> before = app.groupsPage().getAll();
        app.groupsPage().create(newGroup);

        assertThat(app.groupsPage().groupsCount(), equalTo(before.size() + 1));
        List<Group> after = app.groupsPage().getAll();
        assertThat(after.contains(newGroup), is(true));
    }
}
