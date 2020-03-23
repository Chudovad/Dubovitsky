package com.training.nmusabirova.hw11;

import java.io.Serializable;

public interface Folder {
    String getName();
    int getSize();
    Folder getFolder();

    void add(Folder folder);
    void print(int count);
}
