package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class CreateGroupTest extends BaseTest {

    @Test
    public void createGroupTest() {
        GroupData testGroup = new GroupData().title("My test group");
        app.navigateTo().groupsPage();
        List<GroupData> groupsBefore = app.groupsPage().getGroups();
        app.groupsPage().create(testGroup);
        List<GroupData> groupsAfter = app.groupsPage().getGroups();
        Assert.assertEquals(groupsAfter.size(), groupsBefore.size() + 1);
        groupsBefore.add(testGroup);
        groupsBefore.sort(Comparator.comparing(GroupData::title));
        groupsAfter.sort(Comparator.comparing(GroupData::title));
        Assert.assertEquals(groupsAfter, groupsBefore);
    }
}
