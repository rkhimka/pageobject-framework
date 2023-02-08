package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.travello.utils.CommonUtils.generateGroupName;

public class DeleteGroupTest extends BaseTest {

    @BeforeMethod
    public void preconditionStep(){
        app.navigateTo().groupsPage();
        if (!app.groupsPage().isAnyGroupCreated()) {
            app.groupsPage().create(new GroupData().title(generateGroupName()));
        }
    }

    @Test
    public void deleteGroupSuccessTest() {
        app.navigateTo().groupsPage();
        List<GroupData> groupsBefore = app.groupsPage().getGroups();
        int lastGroupIndex = groupsBefore.size() - 1;
        GroupData groupToDelete = groupsBefore.get(lastGroupIndex);
        app.groupsPage().delete(lastGroupIndex);
        List<GroupData> groupsAfter = app.groupsPage().getGroups();

        Assert.assertEquals(groupsAfter.size(), groupsBefore.size() - 1);
        Assert.assertFalse(groupsAfter.contains(groupToDelete));
    }
}
