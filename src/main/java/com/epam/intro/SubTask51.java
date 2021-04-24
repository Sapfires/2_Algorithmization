package com.epam.intro;

import java.util.Arrays;
import java.util.Scanner;

public class SubTask51 {
    public static void main(String[] args) {
        int n = readVariable("Number: ");
        int count = 0;
        while (n != 0) {
            count++;
            n = recalculate(n);
        }
        System.out.println(count);

    }

    private static int recalculate(int n) {
        String nString = String.valueOf(n);
        int[] nArray = getIntegerAsArray(nString);
        int result = n;
        for (int i = 0; i < nArray.length; i++) {
            result -= nArray[i];
        }
        return result;
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
