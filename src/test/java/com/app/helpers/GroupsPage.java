package com.app.helpers;

import com.app.models.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupsPage extends BaseHelper {
    private List<Group> groupsCache = null;

    public GroupsPage(WebDriver wd) {
        super(wd);
    }

    public void create(Group group) {
        initGroupCreation();
        fillGroupInformation(group);
        submitGroupCreation();
        groupsCache = null;
        returnToGroupsPage();
    }

    public void delete(int groupIndex) {
        selectGroup(groupIndex);
        submitGroupDeletion();
        groupsCache = null;
        returnToGroupsPage();
    }

    public void edit(int groupIndex, Group modifiedGroup) {
        selectGroup(groupIndex);
        initGroupEditing();
        fillGroupInformation(modifiedGroup);
        submitGroupEditing();
        groupsCache = null;
        returnToGroupsPage();
    }

    public List<Group> getAll() {
        if (groupsCache == null) {
            groupsCache = new ArrayList<>();
            List<WebElement> elements = wd.findElements(By.xpath("//span[@class='group']"));
            for (WebElement e : elements) {
                groupsCache.add(new Group().title(e.getText()));
            }
        }
        return groupsCache;
    }

    public void fillGroupInformation(Group group) {
        type(By.xpath("//input[@name='group_name']"), group.title());
        type(By.xpath("//textarea[@name='group_header']"), group.header());
        type(By.xpath("//textarea[@name='group_footer']"), group.footer());
    }

    public int groupsCount() {
        return wd.findElements(By.xpath("//input[@name='selected[]']")).size();
    }

    public void initGroupCreation() {
        click(By.xpath("(//input[@value='New group'])[1]"));
    }

    public void initGroupEditing() {
        click(By.xpath("(//input[@value='Edit group'])[1]"));
    }

    public boolean isAnyGroupCreated() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

    public void returnToGroupsPage() {
        click(By.xpath("//a[text()='group page']"));
    }

    public void selectGroup(int index) {
        List<WebElement> groups = wd.findElements(By.xpath("//input[@name='selected[]']"));
        WebElement group = groups.get(index);
        if (!group.isSelected()) {
            group.click();
        }
    }

    public void submitGroupCreation() {
        click(By.xpath("//input[@value='Enter information']"));
    }

    public void submitGroupEditing() {
        click(By.xpath("//input[@value='Update']"));
    }

    public void submitGroupDeletion() {
        click(By.xpath("//input[@value='Delete group(s)'][1]"));
    }

}
