package com.app.notusedclasses;

import com.google.common.collect.ForwardingList;
import com.app.models.Group;
import lombok.NonNull;

import java.util.*;

/**
 * This is wrapper class for the usual java collections that allows to clone objects and
 * implement own methods for interraction with them.
 * Currently only CreateGroup test is written with using this class
 */

public class Groups extends ForwardingList<Group> {
    private final List<Group> delegated;

    public Groups() {
        this.delegated = new ArrayList<>();
    }

    public Groups(Groups groups) {
        this.delegated = new ArrayList<>(groups.delegated);
    }

    @Override
    @NonNull
    protected List<Group> delegate() {
        return delegated;
    }

    public Groups with(Group group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(Group group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
