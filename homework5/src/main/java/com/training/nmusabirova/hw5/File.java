package com.training.nmusabirova.hw5;

class File implements Folder {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Folder getFolder() {
        return this;
    }

    @Override
    public void add(Folder folder) {
    }

    @Override
    public void print(int count) {
        System.out.println(name);
    }
}
