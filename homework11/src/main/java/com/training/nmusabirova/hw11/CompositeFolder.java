package com.training.nmusabirova.hw11;

import java.io.Serializable;
import java.util.ArrayList;

public class CompositeFolder implements Folder, Serializable {
    private final String name;
    private final ArrayList<Folder> folderList = new ArrayList<Folder>();
    private int location;

    public CompositeFolder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return folderList.size();
    }

    @Override
    public Folder getFolder() {
        Folder folder;
        if (location >= getSize()) {
            folder = this;
        } else {
            folder = folderList.get(location);
        }
        return folder;
    }

    @Override
    public void add(Folder folder) {
        folderList.add(folder);
    }

    @Override
    public void print(int count) {
        System.out.println(name);
        for (Folder folder:folderList) {
            for (int i = 0; i < count + 1; i++) {
                System.out.print("  ");
            }
            folder.print(count + 1);
        }
    }

    public void execute(String[] array) {
        if (checkName(array)) {
            Folder furtherFolder;
            Folder actualFolder = this;
            int length = 0;

            while (array.length > length) {
                furtherFolder = findNextElement(actualFolder, array[length]);
                if (actualFolder == furtherFolder) {
                    for (int i = length; i < array.length; i++) {
                        actualFolder = createNewElement(array[i], actualFolder);
                    }
                    break;
                }
                length++;
                actualFolder = actualFolder.getFolder();
            }
        }
    }

    private boolean checkName(String[] array) {
        boolean rezult = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                rezult = false;
                System.out.println("Error! Name must not be empty.");
            }
        }
        return rezult;
    }

    private Folder findNextElement(Folder folder, String elementToFind) {
        Folder actualFolder;
        Folder foundFolder = folder;

        for (location = 0; location < folder.getSize(); location++) {
            actualFolder = folder.getFolder();
            if (actualFolder.getName().equals(elementToFind)) {
                foundFolder = actualFolder;
                break;
            }
        }
        return foundFolder;
    }

    private Folder createNewElement(String name, Folder folder) {
        Folder newFolder = folder;
        if (name.matches(".*\\.[\\d|\\w]*")) {
            File file = new FileBuilder().setName(name).build();
            folder.add(file);
        } else {
            newFolder = new CompositeFolderBuilder().setName(name).build();
            folder.add(newFolder);
        }

        if (newFolder.getFolder().getClass() != File.class) {
            newFolder = newFolder.getFolder();
        }
        return newFolder;
    }
}
