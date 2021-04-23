package com.epam.intro;

import java.util.Scanner;

public class SubTask39 {
    public static void main(String[] args) {
        int lengthArray = readVariable("length of the array: ");
        int[] a = new int[lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            a[i] = readVariable("a[" + i + "]");

        }
        int max1 = a[0];
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < lengthArray; i++) {
            if (a[i] > max1) {
                max2 = max1;
                max1 = a[i];
            }else if (a[i] > max2 && a[i]!=max1) {
                max2 = a[i];
            }
        }
        System.out.println("Maximum 2: " + max2);

    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
