package com.epam.intro;

import java.util.Arrays;
import java.util.Scanner;

public class SubTask27 {
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
        int k = readVariable("k: ");
        a = Arrays.copyOf(a, lengthFirstArray + lengthSecondArray);
        for (int i = lengthFirstArray - 1; i > k; i--) {
            a[a.length - lengthFirstArray + i] = a[i];
        }
        for (int i = k + 1; i < k + 1 + lengthSecondArray; i++) {
            a[i] = b[i - k - 1];
        }
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
