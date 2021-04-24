package com.epam.intro;

import java.util.Scanner;

public class SubTask48 {
    public static void main(String[] args) {
        int k = readVariable("Number: ");
        for (int i = 1; i < k; i++) {
            if (i == getArmstrongNumbers(i)) {
                System.out.println(i);
            }
        }
    }

    private static int getArmstrongNumbers(int i) {
        String iString = Integer.toString(i);
        int[] a = getIntegerAsArray(iString);
        int sum = 0;
        for (int j = 0; j < iString.length(); j++) {
            sum = sum + (int) Math.pow(a[j],iString.length());
        }
        return sum;
    }

    private static int[] getIntegerAsArray(String iString) {
        int[] a = new int[iString.length()];
        for (int j = 0; j < iString.length(); j++) {
            a[j] = Integer.parseInt(iString.substring(j, j + 1));
        }
        return a;
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
