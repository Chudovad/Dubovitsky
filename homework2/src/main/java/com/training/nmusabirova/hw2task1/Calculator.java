package com.training.nmusabirova.hw2task1;

/**
 * Class for passing values through command-line arguments
 * and calculating by a formula with given arguments.
 *
 * @author nmusabirova
 *
 * @version 1.0
 */
public class Calculator {
    /**
     * The main method of the program.
     * Passes values through command line arguments.
     * @param args - arguments
     */
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int p = Integer.parseInt(args[1]);
            double m1 = Double.parseDouble(args[2]);
            double m2 = Double.parseDouble(args[3]);
            calculateG(a, p, m1, m2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Calculates G by the formula.
     * @param a - variable1
     * @param p - variable2
     * @param m1 - variable3
     * @param m2 - variable4
     */
    private static void calculateG(int a, int p, double m1, double m2) {
        double G = (4 * Math.pow(Math.PI, 2) * (Math.pow(a, 3) / (Math.pow(p, 2) * (m1 + m2))));
        System.out.println("G = " + G);
    }
}