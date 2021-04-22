package com.epam.intro;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SubTask26 {
    private static final Integer AMOUNT = 3;
    private static final Map<String, Long> METRICS = new ConcurrentHashMap<>();
    private static final String NEXT_REPLACE_DETECT = "NEXT REPLACE DETECT";
    private static final String FILL_MATRIX = "FILL MATRIX";
    private static final String CHECK_MATRIX = "CHECK MATRIX";
    private static final String REPLACE = "REPLACE";
    private static final String TOTALLY = "TOTALLY";
    private static final String MAX_DETECTION = "MAX DETECTION";
    private static final String MIN_FROM_MAX = "MIN FROM MAX";
    private static final String MERGE = "MERGE";

    public static void main(String[] args) {
        List<Long> originalList = LongStream.range(1, (long) AMOUNT * AMOUNT + 1).boxed().collect(Collectors.toList());
        long[][] matrix = new long[AMOUNT][AMOUNT];
        METRICS.put(NEXT_REPLACE_DETECT, 0L);
        METRICS.put(FILL_MATRIX, 0L);
        METRICS.put(CHECK_MATRIX, 0L);
        METRICS.put(REPLACE, 0L);
        METRICS.put(MAX_DETECTION, 0L);
        METRICS.put(MIN_FROM_MAX, 0L);
        METRICS.put(MERGE, 0L);
        fillMatrix(originalList, matrix);
        long maxNumberOfIterations = LongStream.range(1, (long) AMOUNT * AMOUNT + 1).reduce(1, (x, y) -> x * y);
        System.out.println("Totally " + maxNumberOfIterations);
        System.out.println();
        printMatrix(matrix);
        boolean detected = false;
        long count = 1;
        long startTime = System.currentTimeMillis();
        while (getNextReplacementIndex(originalList) >= 0 && !detected) {
            originalList = replaceByPosition(originalList, getNextReplacementIndex(originalList));
            fillMatrix(originalList, matrix);
            detected = checkMatrix(matrix);
            count++;
            if (System.currentTimeMillis() - startTime > 1000 * 60 * 2) {
                break;
            }
        }
        if (detected) {
            System.out.println();
            printMatrix(matrix);
        }
        System.out.println("Count: " + count);
        METRICS.put(TOTALLY, System.currentTimeMillis() - startTime);
        METRICS.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    private static void printMatrix(long[][] matrix) {
        System.out.println(Arrays.stream(matrix)
                .map(it -> Arrays.stream(it)
                        .boxed()
                        .map(it0 -> String.format("%02d ", it0))
                        .collect(Collectors.joining(" "))).collect(Collectors.joining("\n")));
        System.out.println("-----------");
    }

    private static void fillMatrix(List<Long> originalList, long[][] matrix) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < AMOUNT; i++) {
            for (int j = 0; j < AMOUNT; j++) {
                matrix[i][j] = originalList.get(i * AMOUNT + j);
            }
        }
        fillMetrics(startTime, FILL_MATRIX);
    }

    private static void fillMetrics(long startTime, String metric) {
        METRICS.put(metric, METRICS.get(metric) + System.currentTimeMillis() - startTime);
    }

    private static boolean checkMatrix(long[][] matrix) {
        long startTime = System.currentTimeMillis();
        long expected = AMOUNT * ((long) AMOUNT * AMOUNT + 1) / 2;
        long sumColumn;
        long sumRow;
        boolean canBeCalculated = IntStream.range(0, AMOUNT).boxed().map(it -> matrix[it][it]).mapToLong(it -> it).sum() == expected;
        if (canBeCalculated) {
            canBeCalculated = IntStream.range(0, AMOUNT).boxed().map(it -> matrix[it][AMOUNT - it - 1]).mapToLong(it -> it).sum() == expected;
            for (int i = 0; i < AMOUNT && canBeCalculated; i++) {
                sumColumn = 0;
                sumRow = 0;
                for (int j = 0; j < AMOUNT; j++) {
                    sumColumn += matrix[i][j];
                    sumRow += matrix[j][i];
                }
                if (sumColumn != expected || sumRow != expected) {
                    canBeCalculated = false;
                }
            }
        }
        fillMetrics(startTime, FILL_MATRIX);
        return canBeCalculated;
    }

    private static int getNextReplacementIndex(List<Long> originalList) {
        long startTime = System.currentTimeMillis();
        int result = -1;
        for (int i = originalList.size() - 1; i > 0; i--) {
            if (originalList.get(i) > originalList.get(i - 1)) {
                result = i - 1;
                break;
            }
        }

        fillMetrics(startTime, NEXT_REPLACE_DETECT);
        return result;
    }

    private static List<Long> replaceByPosition(List<Long> originalList, Integer position) {
        long startTime = System.currentTimeMillis();

        long min = Long.MAX_VALUE;
        Long elementForCheck = originalList.get(position);
        for (int i = position + 1; i < originalList.size(); i++) {
            Long element = originalList.get(i);
            if (min > element && element > elementForCheck) {
                min = element;
            }
        }

        fillMetrics(startTime, MIN_FROM_MAX);
        long startTimeMerge = System.currentTimeMillis();
        List<Long> result = new ArrayList<>(originalList.size());
        originalList.remove(min);
        List<Long> subList = originalList.subList(position, originalList.size()).stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < originalList.size(); i++) {
            if (i < position) {
                result.add(originalList.get(i));
            } else if (i == position) {
                result.add(min);
            }
        }
        result.addAll(subList);

        fillMetrics(startTimeMerge, MERGE);
        fillMetrics(startTime, REPLACE);

        return result;
    }

}
