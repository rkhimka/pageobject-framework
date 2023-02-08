package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.travello.utils.CommonUtils.generateGroupName;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends BaseTest {

    @Test
    public void createGroupTest() {
        GroupData testGroup = new GroupData().title(generateGroupName());
        app.navigateTo().groupsPage();
        List<GroupData> groupsBefore = app.groupsPage().getGroups();
        app.groupsPage().create(testGroup);
        List<GroupData> groupsAfter = app.groupsPage().getGroups();
        assertThat(groupsAfter.size(), equalTo(groupsBefore.size() + 1));
        assertThat(groupsAfter.contains(testGroup), is(true));
    }
}
