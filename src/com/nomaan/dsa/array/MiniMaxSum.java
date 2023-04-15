package com.nomaan.dsa.array;

import java.util.List;

// https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/problem
public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        long total = 0;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            total += num;
        }

        System.out.println((total - max) + " " + (total - min));
    }
}
