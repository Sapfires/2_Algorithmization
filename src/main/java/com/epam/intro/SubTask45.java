package com.epam.intro;

import java.util.Scanner;

public class SubTask45 {
    public static void main(String[] args) {
        int a = readVariable("Number: ");
        int b = readVariable("Number: ");
        String aString = Integer.toString(a);
        String bString = Integer.toString(b);
        calculateLength(a, b, aString, bString);
    }

    private static void calculateLength(int a, int b, String aString, String bString) {
        if (aString.length() > bString.length()) {
            System.out.println("There are more digits in number " + a);
        }
        if (aString.length() == bString.length()) {
            System.out.println("There are equal count of digits in two numbers");
        }
        if (aString.length() < bString.length()) {
            System.out.println("There are more digits in number " + b);
        }
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
