package com.travello.tests;

import com.travello.models.GroupData;
import org.testng.annotations.Test;

public class EditGroupTest extends BaseTest {

    @Test
    public void editGroupTest() {
        app.getNavigation().followGroupsPage();
        app.getGroupsPage().selectGroup();
        app.getGroupsPage().initGroupEditing();
        app.getGroupsPage().fillGroupInformation(
                new GroupData("New title", "new header", "new footer"));
        app.getGroupsPage().submitGroupEditing();
        app.getNavigation().followGroupsPage();
    }
}
