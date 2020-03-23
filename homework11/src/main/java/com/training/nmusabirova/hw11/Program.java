package com.training.nmusabirova.hw11;

import java.io.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        CompositeFolder folder = new CompositeFolderBuilder().setName("Folder").build();

        try {
            FileInputStream fileStream = new FileInputStream("Structure.struct");
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            folder = (CompositeFolder) objectStream.readObject();
            objectStream.close();
        } catch (FileNotFoundException e) {
            new File("Structure.struct");
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Enter the path to create it.");
            System.out.println("Enter \"print\" to display the file and folder structure.");
            System.out.println("Enter \"save\" to save the structure.");
            System.out.println("Enter \"stop\" to end the program.");

            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (input.equals("print")) {
                folder.print(0);
            } else if (input.equals("stop")) {
                break;
            } else if (input.equals("save")) {
                try {
                    FileOutputStream file = new FileOutputStream("Structure.struct");
                    ObjectOutputStream object = new ObjectOutputStream(file);
                    object.writeObject(folder);
                    object.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                String[] array = input.split("/");
                folder.execute(array);
            }
        }
    }
}
