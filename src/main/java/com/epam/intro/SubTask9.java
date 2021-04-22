package com.epam.intro;

import java.util.*;

public class SubTask9 {
    static class MinFromMostPopulars {
        int count = 0;
        int value;

        public MinFromMostPopulars(int count, int value) {
            this.count = count;
            this.value = value;
        }

        @Override
        public String toString() {
            return "MinFromMostPopulars{" +
                    "count=" + count +
                    ", value=" + value +
                    '}';
        }
    }
    public static void main(String[] args) {
        int n = readVariable("number of elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readVariable("a[" + i + "]");
        }
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            counterMap.putIfAbsent(a[i], 0);
            int count = counterMap.get(a[i]);
            counterMap.put(a[i], count + 1);
        }
        Map.Entry<Integer, Integer> firstElement = counterMap.entrySet().iterator().next();
        MinFromMostPopulars minFromMostPopulars = new MinFromMostPopulars(firstElement.getValue(), firstElement.getKey());
        for (Map.Entry<Integer, Integer> entry: counterMap.entrySet() ){
            if (entry.getValue() > minFromMostPopulars.count) {
                minFromMostPopulars.count = entry.getValue();
                minFromMostPopulars.value = (entry.getKey());
            }else if (entry.getValue() == minFromMostPopulars.count){
                if (entry.getKey()<minFromMostPopulars.value){
                    minFromMostPopulars.value = (entry.getKey());
                }
            }
        }
            System.out.println("The result is: " + minFromMostPopulars);

    }

    public static int readVariable(String variableName) {
        System.out.println("Please input " + variableName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}