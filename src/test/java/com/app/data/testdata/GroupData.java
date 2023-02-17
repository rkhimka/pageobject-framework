package com.app.data.testdata;

import com.app.models.Group;

import static com.app.utils.CommonUtils.randomAlphanumericStr;

public class GroupData {

    public static String generateGroupName() {
        return String.format("Group_%s", randomAlphanumericStr(10));
    }

    public static Group getGroupData(){
        return new Group().title(generateGroupName())
                .header("Test header " + randomAlphanumericStr(5))
                .footer("Test footer " + randomAlphanumericStr(5));
    }
}
