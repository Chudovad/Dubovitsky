package com.training.nmusabirova.hw5;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        CompositeFolder folder = new CompositeFolderBuilder().setName("Folder").build();
        while (true) {
            System.out.println("Enter the path to create it.");
            System.out.println("Enter \"print\" to display the file and folder structure.");
            System.out.println("Enter \"stop\" to end the program.");

            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (input.equals("print")) {
                folder.print(0);
            } else if (input.equals("stop")) {
                break;
            } else {
                String[] array = input.split("/");
                folder.execute(array);
            }
        }
    }
}
