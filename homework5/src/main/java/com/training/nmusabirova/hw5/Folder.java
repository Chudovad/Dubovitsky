package com.training.nmusabirova.hw5;

public interface Folder {
    String getName();
    int getSize();
    Folder getFolder();

    void add(Folder folder);
    void print(int count);
}
