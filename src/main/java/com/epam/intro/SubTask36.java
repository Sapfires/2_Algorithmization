package com.epam.intro;

import java.util.Scanner;

public class SubTask36 {
    public static void main(String[] args) {
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = readVariable("Number " + i + ":");
        }
        int greatestCommonDivisor = getGreatestCommonDivisor(a);
        System.out.println("Greatest Common Divisor: " + greatestCommonDivisor);

    }

    private static int getGreatestCommonDivisor(int[] a) {
        int greatestCommonDivisor = 1;
        for (int i = 2; i <= getMax(a); i++) {
            if (isDivisor(a, i)) {
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }

    private static boolean isDivisor(int[] a, int i) {
        boolean isDivisor = true;
        for (int j = 0; j < 4 && isDivisor; j++) {
            isDivisor = a[j] % i == 0;
        }
        return isDivisor;
    }

    private static int getMax(int[] a) {
        int max = a[0];
        for (int i = 0; i < 4; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
