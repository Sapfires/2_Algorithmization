package com.epam.intro;

import java.util.Arrays;
import java.util.Scanner;

public class SubTask50 {
    public static void main(String[] args) {
        int n = readVariable("Number: ") - 1;
        int firstNumber = generateFirstNumber(n);
        int lastNumber = generateFirstNumber(n + 1);
        int sum = 0;
        for (int i = firstNumber; i < lastNumber; i++) {
            sum = isDoesNumberHoldsEvenDigits(i) ? sum : (sum + i);
        }
        System.out.println(sum);
        long numberOfEven = getNumberOfEven(sum);
        System.out.println(numberOfEven);
    }

    private static long getNumberOfEven(int sum) {
        String sumString = String.valueOf(sum);
        return Arrays.stream(getIntegerAsArray(sumString)).filter(it -> it % 2 == 0).count();
    }

    private static boolean isDoesNumberHoldsEvenDigits(int i) {
        String iString = String.valueOf(i);
        int[] iArray = getIntegerAsArray(iString);
        return Arrays.stream(iArray).boxed().anyMatch(it -> it % 2 == 0);
    }

    private static int generateFirstNumber(int numberOfDigits) {
        return Integer.parseInt(String.format("1%0" + numberOfDigits + "d", 0));
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
