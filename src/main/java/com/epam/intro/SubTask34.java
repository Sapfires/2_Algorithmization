package com.epam.intro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SubTask34 {
    static class CustomNumber {
        long numerator;
        long denominator;
        Long realNumerator;

        public CustomNumber(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public static void main(String[] args) {
        long n = readVariable("n");
        List<CustomNumber> customNumberList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long numerator = readVariable("numerator");
            long denominator = readVariable("denominator");
            customNumberList.add(new CustomNumber(numerator, denominator));
        }
        long denominatorMax = 1;
        for (int i = 0; i < n; i++) {
            denominatorMax = denominatorMax * customNumberList.get(i).denominator;
        }
        for (int i = 0; i < n; i++) {
            customNumberList.get(i).realNumerator = customNumberList.get(i).numerator *
                    (denominatorMax / customNumberList.get(i).denominator);
        }
        List<CustomNumber> toSort = new ArrayList<>(customNumberList);
        toSort.sort((Comparator.comparing(o -> o.realNumerator)));
        for (CustomNumber it : toSort) {
            System.out.print(it.numerator + "/" + it.denominator + " ");
        }


    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
