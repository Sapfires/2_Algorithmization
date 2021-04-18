package com.epam.intro;

import java.util.Arrays;
import java.util.Scanner;

public class SubTask28 {
    public static void main(String[] args) {
        int lengthFirstArray = readVariable("length of the first array: ");
        int[] a = new int[lengthFirstArray];
        for (int i = 0; i < lengthFirstArray; i++) {
            a[i] = readVariable("a[" + i + "]");

        }
        int lengthSecondArray = readVariable("length of the second array: ");
        int[] b = new int[lengthSecondArray];
        for (int j = 0; j < lengthSecondArray; j++) {
            b[j] = readVariable("b[" + j + "]");

        }
        a = Arrays.copyOf(a, lengthFirstArray + lengthSecondArray);
        for (int i = lengthFirstArray; i < a.length; i++) {
            a[i] = b[i - lengthFirstArray];
        }
        int countOfReplacement = 0;
        do {
            countOfReplacement = 0;
            for (int i = 0; i < a.length-1; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    countOfReplacement++;
                }
            }

        }
        while (countOfReplacement > 0);
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
