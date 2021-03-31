package com.epam.intro;

import java.util.Arrays;
import java.util.Scanner;

public class SubTask10 {
    public static void main(String[] args) {
        int n = readVariable("number of elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readVariable("a[" + i + "]");
        }
        for (int i = 0; i < n / 2; i++) {
            a[i] = a[2 * i];
        }
        for (int i = n / 2; i < n; i++) {
            a[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
