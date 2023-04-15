package com.nomaan.dsa.mathematics;

import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem
public class PlusMinus {
    public static void main(String[] args) {
        Integer[] arr = {-4, 3, -9, 0, 4, 1};
        plusMinus(Arrays.asList(arr));
    }
    public static void plusMinus(List<Integer> arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int num : arr) {
            if (num == 0) zero++;
            else if (num > 0) positive++;
            else negative++;
        }

        int total = positive + negative + zero;

        if (total == 0) {
            System.out.printf("%.6f\n", 0d);
            System.out.printf("%.6f\n", 0d);
            System.out.printf("%.6f\n", 0d);
        }

        System.out.printf("%.6f\n",(double)positive/total);
        System.out.printf("%.6f\n",(double)negative/total);
        System.out.printf("%.6f\n",(double)zero/total);
    }
}
