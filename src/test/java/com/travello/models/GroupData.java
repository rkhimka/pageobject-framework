package com.travello.models;

import com.travello.helpers.GroupsPage;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class GroupData {
    private String groupTitle;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String groupHeader;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String groupFooter;
}
