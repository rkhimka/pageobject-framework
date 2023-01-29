package com.travello.tests;

import org.testng.annotations.Test;

public class DeleteGroupTest extends BaseTest {

    @Test
    public void deleteGroupSuccessTest() {
        app.getNavigation().followGroupsPage();
        app.getGroupsPage().selectGroup();
        app.getGroupsPage().submitGroupDeletion();
        app.getNavigation().followGroupsPage();
    }

}
