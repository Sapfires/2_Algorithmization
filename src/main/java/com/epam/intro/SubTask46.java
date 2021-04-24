package com.epam.intro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubTask46 {
    public static void main(String[] args) {
        int k = readVariable("Number: ");
        int n = readVariable("Number: ");
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            int sum = getSumOfNumbers(i);
            if (sum == k) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    private static int getSumOfNumbers(int i) {
        String iString = Integer.toString(i);
        int[] a = getIntegerAsArray(iString);
        int sum = 0;
        for ( int j = 0; j < iString.length(); j++) {
            sum = sum + a[j];
        }
        return sum;
    }

    private static int[] getIntegerAsArray(String iString) {
        int[] a = new int[iString.length()];
        for (int j = 0; j < iString.length(); j++) {
            a[j] = Integer.parseInt(iString.substring(j, j+1));
        }
        return a;
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
