package com.epam.intro;

import java.util.Scanner;

public class SubTask29 {
    public static void main(String[] args) {
        int lengthArray = readVariable("length of the first array: ");
        int[] a = new int[lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            a[i] = readVariable("a[" + i + "]");

        }
        for (int j = 0; j < lengthArray; j++) {

            int max = a[j];
            int position = j;
            for (int i = j; i < lengthArray; i++) {
                if (a[i] > max) {
                    max = a[i];
                    position = i;
                }
            }
            a[position] = a[j];
            a[j] = max;
        }
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