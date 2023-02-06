package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteGroupTest extends BaseTest {

    @BeforeMethod
    public void preconditionStep(){
        app.navigateTo().groupsPage();
        if (!app.groupsPage().isAnyGroupCreated()) {
            app.groupsPage().create(new GroupData().title("My test group"));
        }
    }

    @Test
    public void deleteGroupSuccessTest() {
        app.navigateTo().groupsPage();
        List<GroupData> groupsBefore = app.groupsPage().getGroups();
        int lastGroup = groupsBefore.size() - 1;
        app.groupsPage().delete(lastGroup);
        List<GroupData> groupsAfter = app.groupsPage().getGroups();
        Assert.assertEquals(groupsAfter.size(), groupsBefore.size() - 1);
        groupsBefore.remove(lastGroup);
        Assert.assertEquals(groupsAfter, groupsBefore);
    }
}
