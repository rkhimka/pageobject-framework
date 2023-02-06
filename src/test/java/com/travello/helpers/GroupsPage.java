package com.travello.helpers;

import com.travello.models.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupsPage extends BaseHelper {

    public GroupsPage(WebDriver wd) {
        super(wd);
    }

    public void delete(int groupIndex) {
        selectGroup(groupIndex);
        submitGroupDeletion();
        returnToGroupsPage();
    }

    public void create(GroupData groupData) {
        initGroupCreation();
        fillGroupInformation(groupData);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath("//span[@class='group']"));
        for (WebElement e : elements) {
            groups.add(new GroupData(e.getText(), null, null));
        }
        return groups;
    }

    public void edit(int groupIndex, GroupData modifiedGroup) {
        selectGroup(groupIndex);
        initGroupEditing();
        fillGroupInformation(modifiedGroup);
        submitGroupEditing();
        returnToGroupsPage();
    }

    public void fillGroupInformation(GroupData group) {
        type(By.xpath("//input[@name='group_name']"), group.getGroupTitle());
        type(By.xpath("//textarea[@name='group_header']"), group.getGroupHeader());
        type(By.xpath("//textarea[@name='group_footer']"), group.getGroupFooter());
    }

    public int getGroupsCount() {
        //TODO: add followGroupsPage method here
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

    public void returnToGroupsPage(){
        click(By.xpath("//a[text()='group page']"));
    }

    public void selectGroup(int index) {
        WebElement group = wd.findElements(By.xpath("//input[@name='selected[]']")).get(index);
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
