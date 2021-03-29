package com.epam.intro;

import java.util.Scanner;

public class SubTask1 {

    public static void main(String[] args) {
        int n = readVariable("number of elements");
        int k = readVariable("common divider");
        int sum = 0;
        int[] a = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = readVariable("a["+i+"]");
        }
        for (int i = 0; i < n; i++) {
            if (a[i] % k == 0) {
                sum = sum + a[i];
            }
        }
        System.out.println("The result is: " + sum);

    }
    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        if (result <0 ){
            throw new RuntimeException("It must be more than 0");
        }
        return result;
    }
}
