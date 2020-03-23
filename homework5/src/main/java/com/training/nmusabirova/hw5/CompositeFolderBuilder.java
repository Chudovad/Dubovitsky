package com.training.nmusabirova.hw5;

public class CompositeFolderBuilder {
    private String name;

    public CompositeFolderBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompositeFolder build() {
        return new CompositeFolder(name);
    }
}
