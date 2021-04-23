package com.epam.intro;

import java.util.Scanner;

public class SubTask42 {
    public static void main(String[] args) {
        int lengthOfArray = readVariable("Length of array: ");
        int k = readVariable("Left bound: ");
        int m = readVariable("Right bound: ");
        if (m + 2 >= lengthOfArray) {
            throw new RuntimeException("Wrong right bound");
        }
        int[] a = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            a[i] = readVariable("a" + "[" + i + "]");
        }
        for (int i = k; i <= m; i++) {
            calculate(a,i);
        }
    }
    public static void calculate (int[] a, int position) {
        System.out.println(a[position] + a[position+1] + a[position+2]);
    }
    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
