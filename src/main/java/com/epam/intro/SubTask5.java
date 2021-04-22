package com.epam.intro;

import java.util.Scanner;

public class SubTask5 {
    public static void main(String[] args) {
        int n = readVariable("number of elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readVariable("a[" + i + "]");
        }
        for (int i = 0; i < n; i++) {
            if (a[i] > i) {
                System.out.print(a[i] + " ");
            }
        }

    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
