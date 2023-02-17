package com.app.models;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(fluent = true, chain = true)
@ToString
@EqualsAndHashCode
public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String nickName;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String company;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String homePhone;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String mobilePhone;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String workPhone;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String groupName;
    private String allPhones;
}
