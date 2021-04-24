package com.epam.intro;

import java.util.Scanner;

public class SubTask44 {
    public static void main(String[] args) {
        int n = readVariable("Number: ");
        String string = Integer.toString(n);
        int [] a = new int[string.length()];
        calculateArray(string, a);
    }

    private static void calculateArray(String string, int[] a) {
        for (int i = 0; i < string.length(); i++) {
            a[i] = Integer.parseInt(string.substring(i,i+1));
            System.out.print(a[i] + " ");
        }
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

