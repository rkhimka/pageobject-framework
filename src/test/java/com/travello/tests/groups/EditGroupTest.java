package com.travello.tests.groups;

import com.travello.models.GroupData;
import com.travello.models.Groups;
import com.travello.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static com.travello.utils.CommonUtils.generateGroupName;
import static com.travello.utils.CommonUtils.generateRandomAlphanumericStr;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditGroupTest extends BaseTest {

    @BeforeMethod
    public void preconditionStep() {
        app.navigateTo().groupsPage();
        if (!app.groupsPage().isAnyGroupCreated()) {
            app.groupsPage().create(new GroupData().title(generateGroupName()));
        }
    }

    @Test
    public void editGroupTest() {
        GroupData modifiedData = new GroupData()
                .title(generateGroupName())
                .header(generateRandomAlphanumericStr(50))
                .footer(generateRandomAlphanumericStr(50));
        app.navigateTo().groupsPage();
        Groups groupsBefore = app.groupsPage().getGroups();
        int lastGroupIndex = groupsBefore.size() - 1;
        GroupData groupToModify = groupsBefore.get(lastGroupIndex);
        app.groupsPage().edit(lastGroupIndex, modifiedData);
        Groups groupsAfter = app.groupsPage().getGroups();
        Groups g = groupsBefore.without(groupToModify).with(modifiedData);

        g.sort(Comparator.comparing(GroupData::title));
        groupsAfter.sort(Comparator.comparing(GroupData::title));
        assertThat(groupsAfter.size(), equalTo(groupsBefore.size()));
        assertThat(groupsAfter, equalTo(g));
//        assertThat(groupsAfter.contains(modifiedData), is(true));
//        assertThat(groupsAfter.contains(groupToModify), is(false));
    }
}
