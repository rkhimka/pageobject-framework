package com.travello.models;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(fluent = true, chain = true)
@ToString
@EqualsAndHashCode
public class GroupData {

    private String title;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String header;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String footer;
}
