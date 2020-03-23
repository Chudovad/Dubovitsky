package com.training.nmusabirova.hw11;

import java.io.Serializable;

public class FileBuilder {
    private String name;

    public FileBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public File build() {
        return new File(name);
    }
}
