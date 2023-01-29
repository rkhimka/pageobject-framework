package com.travello.helpers;

import com.travello.models.GroupData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor
@AllArgsConstructor
public class GroupsPage {
    private WebDriver wd;

    public void submitGroupCreation() {
        wd.findElement(By.xpath("//input[@value='Enter information']")).click();
    }

    public void fillGroupInformation(GroupData group) {
        wd.findElement(By.xpath("//input[@name='group_name']")).sendKeys(group.getGroupTitle());
        wd.findElement(By.xpath("//textarea[@name='group_header']")).sendKeys(group.getGroupHeader());
        wd.findElement(By.xpath("//textarea[@name='group_footer']")).sendKeys(group.getGroupFooter());
    }

    public void initGroupCreation() {
        wd.findElement(By.xpath("//input[@value='New group'][1]")).click();
    }

    public void submitGroupDeletion() {
        wd.findElement(By.xpath("//input[@value='Delete group(s)'][1]")).click();
    }

    public void selectGroup() {
        wd.findElement(By.xpath("(//input[@name='selected[]'])[1]")).click();
    }
}
