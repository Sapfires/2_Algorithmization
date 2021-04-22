package com.epam.intro;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubTask31 {
    public static void main(String[] args) {
        int lengthArray = readVariable("length of the first array: ");
        int[] a = new int[lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            a[i] = readVariable("a[" + i + "]");

        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lengthArray; i++) {
            boolean dectected = false;
            int middle = result.size() / 2;
            int position = middle;
            int leftBound = 0;
            int rightBound = result.size();
            while (!dectected) {
                if (rightBound - leftBound == 0) {
                    position = leftBound;
                    dectected = true;
                } else if (rightBound - leftBound == 1) {
                    if (a[i] > result.get(middle)) {
                        position = rightBound;
                        dectected = true;
                    } else {
                        position = leftBound;
                        dectected = true;
                    }
                } else {
                    int left = result.get(middle - 1);
                    int right = result.get(middle);
                    if (a[i] < left) {
                        rightBound = middle;
                        middle = leftBound + (rightBound - leftBound) / 2;
                    } else if (a[i] == left || a[i] <= right) {
                        position = middle;
                        dectected = true;
                    } else {
                        leftBound = middle;
                        middle = leftBound + (rightBound - leftBound) / 2;
                    }

                }
            }
            result.add(position, a[i]);
        }
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
