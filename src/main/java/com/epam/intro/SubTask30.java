package com.epam.intro;

import java.util.Scanner;

public class SubTask30 {
    public static void main(String[] args) {
        int lengthArray = readVariable("length of the first array: ");
        int[] a = new int[lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            a[i] = readVariable("a[" + i + "]");

        }
        int countOfReplacement = 0;
        do {
            countOfReplacement = 0;
            for (int i = 0; i < lengthArray-1; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    countOfReplacement++;
                }
            }

        }
        while (countOfReplacement > 0);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}