package com.epam.intro;

import java.util.Arrays;
import java.util.Scanner;

public class SubTask49 {
    public static void main(String[] args) {
        int n = readVariable("Number: ") - 1;
        int firstNumber = generateFirstNumber(n);
        int lastNumber = generateFirstNumber(n+1);
        for (int i = firstNumber; i < lastNumber; i++) {
            String iString = String.valueOf(i);
            int[] iArray = getIntegerAsArray(iString);
            iArray = sort(iArray);
            int result = arrayToInt(iArray);
            if (result == i) {
                System.out.println(result);
            }
        }
    }

    private static int generateFirstNumber(int numberOfDigits) {
        return Integer.parseInt(String.format("1%0" + numberOfDigits + "d", 0));
    }
    private static int arrayToInt(int[] a) {
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result = result + a[i];
        }
        return Integer.parseInt(result);
    }
    private static int[] sort(int[] a) {
        return Arrays.stream(a).distinct().sorted().toArray();
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
