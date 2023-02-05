package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

public class DeleteGroupTest extends BaseTest {

    @Test
    public void deleteGroupSuccessTest() {
        app.getNavigation().followGroupsPage();
        if (!app.getGroupsPage().isAnyGroupCreated()) {
            app.getGroupsPage().createGroup(new GroupData("My test group",
                    "test header", "test footer"));
        }
        app.getNavigation().followGroupsPage();
        app.getGroupsPage().selectGroup();
        app.getGroupsPage().submitGroupDeletion();
        app.getNavigation().followGroupsPage();
    }
}
