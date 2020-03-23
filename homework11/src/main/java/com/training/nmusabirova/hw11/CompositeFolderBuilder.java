package com.training.nmusabirova.hw11;

import java.io.Serializable;

public class CompositeFolderBuilder implements Serializable {
    private String name;

    public CompositeFolderBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompositeFolder build() {
        return new CompositeFolder(name);
    }
}
