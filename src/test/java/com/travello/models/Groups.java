package com.travello.models;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.ForwardingSet;
import lombok.NonNull;

import java.util.*;

/**
 * This is wrapper class for the usual java collections that allows to clone objects and
 * implement own methods for interraction with them.
 * Currently only CreateGroup test is written with using this class
 */

public class Groups extends ForwardingList<GroupData> {
    private final List<GroupData> delegated;

    public Groups() {
        this.delegated = new ArrayList<>();
    }

    public Groups(Groups groups) {
        this.delegated = new ArrayList<>(groups.delegated);
    }

    @Override
    @NonNull
    protected List<GroupData> delegate() {
        return delegated;
    }

    public Groups with(GroupData group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
