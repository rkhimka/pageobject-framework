package com.travello.tests;

import com.travello.models.GroupData;
import org.testng.annotations.Test;

public class CreateGroupTest extends BaseTest {

    @Test
    public void createGroupTest() {
        app.getNavigation().followGroupsPage();
        app.getGroupsPage().initGroupCreation();
        app.getGroupsPage().fillGroupInformation(new GroupData("My test group", "test header", "test footer"));
        app.getGroupsPage().submitGroupCreation();
        app.getNavigation().followGroupsPage();
    }

}
