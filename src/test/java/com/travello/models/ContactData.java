package com.travello.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactData {
    private String firstName;
    private String lastName;
    private String nickName;
    private String company;
    private String email;
    private String groupName;
}
