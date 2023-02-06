package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class EditGroupTest extends BaseTest {

    @BeforeMethod
    public void preconditionStep(){
        app.navigateTo().groupsPage();
        if (!app.groupsPage().isAnyGroupCreated()) {
            app.groupsPage().create(new GroupData().title("My test group"));
        }
    }

    @Test
    public void editGroupTest() {
        GroupData modifiedData = new GroupData()
                .title("New group")
                .header("New header")
                .footer("New footer");
        app.navigateTo().groupsPage();
        List<GroupData> groupsBefore = app.groupsPage().getGroups();
        int lastGroup = groupsBefore.size() - 1;
        app.groupsPage().edit(lastGroup, modifiedData);
        List<GroupData> groupsAfter = app.groupsPage().getGroups();
        Assert.assertEquals(groupsAfter.size(), groupsBefore.size());
        groupsBefore.remove(lastGroup);
        groupsBefore.add(modifiedData);
        groupsBefore.sort(Comparator.comparing(GroupData::title));
        groupsAfter.sort(Comparator.comparing(GroupData::title));
        Assert.assertEquals(groupsAfter, groupsBefore);
    }

}
