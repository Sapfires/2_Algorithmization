package com.epam.intro;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubTask8 {
    public static void main(String[] args) {
        int n = readVariable("number of elements");
        int[] a = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = readVariable("a["+i+"]");
        }
        int min = Arrays.stream(a).min().getAsInt();
        Arrays.stream(a).filter(it->it>min).boxed().map(it->it+" ").forEach(System.out::print);

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
