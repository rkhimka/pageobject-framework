package com.travello.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupData {
    private String groupTitle;
    private String groupHeader;
    private String groupFooter;
}
