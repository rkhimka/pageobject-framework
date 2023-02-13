package com.travello.helpers;

import com.travello.models.GroupData;
import com.travello.models.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    public List<GroupData> getGroups() {
//        List<GroupData> groups = new ArrayList<>();
//        List<WebElement> elements = wd.findElements(By.xpath("//span[@class='group']"));
//        for (WebElement e : elements) {
//            groups.add(new GroupData().title(e.getText()));
//        }
//        return groups;
//    }

    /**
     * This method is rewritten for support of Groups wrapper
     */
    public Groups getGroups() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.xpath("//span[@class='group']"));
        for (WebElement e : elements) {
            groups.add(new GroupData().title(e.getText()));
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
        type(By.xpath("//input[@name='group_name']"), group.title());
        type(By.xpath("//textarea[@name='group_header']"), group.header());
        type(By.xpath("//textarea[@name='group_footer']"), group.footer());
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
