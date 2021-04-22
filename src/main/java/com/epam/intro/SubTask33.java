package com.epam.intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class SubTask33 {
    static class Duplicate {
        Integer value;
        Integer beginPosition;
        Integer endPosition;
        Integer valueBefore;
        Integer valueAfter;
        Boolean isOk;

        public Duplicate(Integer value, Integer beginPosition, Integer endPosition, Integer valueBefore, Integer valueAfter) {
            this.value = value;
            this.beginPosition = beginPosition;
            this.endPosition = endPosition;
            this.valueBefore = valueBefore;
            this.valueAfter = valueAfter;
            isOk = false;
        }

        public String toString() {
            return value + " [" + beginPosition + "-" + endPosition + "] " + ">" + valueBefore + " - " + valueAfter + "<";

        }

    }

    public static void main(String[] args) {
//        int n = readVariable("Length of the first array: ");
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = readVariable("a[" + i + "]");
//        }
//
//        int m = readVariable("Length of the second array: ");
//        int[] b = new int[m];
//        for (int i = 0; i < m; i++) {
//            b[i] = readVariable("a[" + i + "]");
//        }
        int[] a = new int[]{0, 1, 5, 15, 15, 15, 25};
        int[] b = new int[]{3, 4, 4, 8, 10, 11, 11, 17, 28};
        List<Integer> reducedB = new ArrayList<>();
        int previousValue = b[0];
        reducedB.add(previousValue);
        for (int i = 1; i < b.length; i++) {
            if (b[i] != previousValue) {
                reducedB.add(b[i]);
                previousValue = b[i];
            }
        }


        previousValue = a[0];

        Map<Integer, Duplicate> duplicates = new HashMap<>();
        for (int i = 1; i < a.length; i++) {
            if (a[i] == previousValue) {
                duplicates.putIfAbsent(a[i], new Duplicate(a[i], i - 1, i, i - 2 < 0 ? 0 : a[i - 2], i + 1 == a.length ? a[i] + 1 : a[i + 1]));
                duplicates.get(a[i]).endPosition = i;
                duplicates.get(a[i]).valueAfter = i + 1 == a.length ? a[i] + 1 : a[i + 1];
            } else {
                previousValue = a[i];
            }
        }


        boolean statusFailed = false;
        boolean allIsOk = false;
        while (!statusFailed && !allIsOk) {
            Map<Integer, Duplicate> recalculatedDuplicates = new HashMap<>();

            int countOfRecalculation = 0;
            do {
                countOfRecalculation = 0;
                Duplicate previousDuplicate = duplicates.values().iterator().next();
                boolean added = false;
                for (Map.Entry<Integer, Duplicate> entry : duplicates.entrySet()) {
                    if (entry.getValue().equals(previousDuplicate)) {

                    } else if ((entry.getValue().beginPosition <= previousDuplicate.endPosition && entry.getValue().beginPosition >= previousDuplicate.beginPosition)
                            || (entry.getValue().endPosition <= previousDuplicate.endPosition && entry.getValue().endPosition >= previousDuplicate.beginPosition)) {
                        Duplicate duplicate = new Duplicate(previousDuplicate.value, previousDuplicate.beginPosition, entry.getValue().beginPosition, previousDuplicate.valueBefore, entry.getValue().valueAfter);
                        recalculatedDuplicates.put(duplicate.value, duplicate);
                        previousDuplicate = duplicate;
                        countOfRecalculation++;
                        added = true;
                    } else {
                        recalculatedDuplicates.put(previousDuplicate.value, previousDuplicate);
                        added = true;
                    }
                    if (!added) {
                        recalculatedDuplicates.put(previousDuplicate.value, previousDuplicate);
                    }
                }
                duplicates = recalculatedDuplicates;
                recalculatedDuplicates = new HashMap<>();
            } while (countOfRecalculation > 0);
            statusFailed = false;
            for (Map.Entry<Integer, Duplicate> entry : duplicates.entrySet()) {
                if (!statusFailed) {
                    while (!entry.getValue().isOk && !statusFailed) {
                        int sum = 1;
                        for (int i = 0; i < reducedB.size(); i++) {

                            if (entry.getValue().valueBefore < reducedB.get(i) && entry.getValue().valueAfter > reducedB.get(i)) {
                                sum++;
                            }
                        }
                        if (sum >= entry.getValue().endPosition - entry.getValue().beginPosition + 1) {
                            entry.getValue().isOk = true;
                        } else {
                            if (entry.getValue().endPosition + 1 == a.length && entry.getValue().beginPosition - 1 < 0) {
                                statusFailed = true;
                                break;
                            } else {
                                entry.getValue().beginPosition = entry.getValue().beginPosition - 1 < 0 ? 0 : entry.getValue().beginPosition - 1;
                                entry.getValue().endPosition = entry.getValue().endPosition + 1 == a.length ? entry.getValue().endPosition : entry.getValue().endPosition + 1;
                                entry.getValue().valueBefore = entry.getValue().beginPosition > 0 ? a[entry.getValue().beginPosition - 1] : 0;
                                entry.getValue().valueAfter = entry.getValue().endPosition + 1 == a.length ? a[a.length - 1] + 1 : a[entry.getValue().endPosition + 1];
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            allIsOk = true;
            for (Map.Entry<Integer, Duplicate> entry : duplicates.entrySet()) {
                if (!entry.getValue().isOk) {
                    allIsOk = false;
                    break;
                }
            }
        }


        for (
                int i = 0;
                i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (
                int i = 0;
                i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        for (
                int i = 0; i < reducedB.size(); i++) {
            System.out.print(reducedB.get(i) + " ");
        }

        System.out.println();

        for (
                Map.Entry<Integer, Duplicate> entries : duplicates.entrySet()) {
            System.out.println(entries.getValue() + " ");

        }

    }


    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
