package com.travello.helpers;

import com.travello.models.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupsPage extends BaseHelper{

    public GroupsPage(WebDriver wd) {
        super(wd);
    }

    public void fillGroupInformation(GroupData group) {
        type(By.xpath("//input[@name='group_name']"), group.getGroupTitle());
        type(By.xpath("//textarea[@name='group_header']"), group.getGroupHeader());
        type(By.xpath("//textarea[@name='group_footer']"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.xpath("(//input[@value='New group'])[1]"));
    }

    public void initGroupEditing() {
        click(By.xpath("(//input[@value='Edit group'])[1]"));
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

    public void selectGroup() {
        click(By.xpath("(//input[@name='selected[]'])[1]"));
    }
}
