package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.tests.BaseTest;
import org.testng.annotations.Test;

public class CreateGroupTest extends BaseTest {

    @Test
    public void createGroupTest() {
        app.getNavigation().followGroupsPage();
        app.getGroupsPage().createGroup(new GroupData("My test group",
                "test header", "test footer"));
        app.getNavigation().followGroupsPage();
    }
}
