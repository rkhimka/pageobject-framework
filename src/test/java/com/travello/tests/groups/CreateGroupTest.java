package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.models.Groups;
import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static com.travello.utils.CommonUtils.generateGroupName;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends BaseTest {

    @Test
    public void createGroupTest() {
        GroupData newGroup = new GroupData().title(generateGroupName());
        app.navigateTo().groupsPage();
//        List<GroupData> groupsBefore = app.groupsPage().getGroups();
        Groups before = app.groupsPage().getGroups();
        app.groupsPage().create(newGroup);
        Groups after = app.groupsPage().getGroups();
        Groups expected = before.with(newGroup);
        assertThat(after.size(), equalTo(before.size() + 1));
        expected.sort(Comparator.comparing(GroupData::title));
        after.sort(Comparator.comparing(GroupData::title));
        assertThat(after, equalTo(expected));
    }
}
