package com.app.models;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(fluent = true, chain = true)
@ToString
@EqualsAndHashCode
public class Group {
    private String title;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String header;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String footer;
}
