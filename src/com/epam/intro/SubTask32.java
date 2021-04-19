package com.epam.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubTask32 {
    public static void main(String[] args) {
        int lengthArray = readVariable("length of the first array: ");
        int[] a = new int[lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            a[i] = readVariable("a[" + i + "]");

        }
        boolean detected = false;
        int position = 0;
        printArray(a);
        while (!detected){
            position = Math.max(position, 0);
            if(position == lengthArray-1){
                detected = true;
            } else {
                if(a[position]<=a[position+1]){
                    position++;
                }else {
                    int tmp = a[position];
                    a[position] = a[position+1];
                    a[position+1] =tmp;
                    position--;
                }
            }
        }

        printArray(a);
    }

    private static void printArray(int[] a){
        System.out.println(Arrays.stream(a).boxed().map(it -> Integer.toString(it)).collect(Collectors.joining(" ")));
        System.out.println("---------------------");
    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
