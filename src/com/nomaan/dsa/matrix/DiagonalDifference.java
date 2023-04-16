package com.nomaan.dsa.matrix;

import java.util.List;

// https://www.hackerrank.com/challenges/diagonal-difference/problem
public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();

        int primarySum = 0;
        for (int i = 0; i < n; i++) primarySum += arr.get(i).get(i);

        int secondarySum = 0;
        for (int i = 0; i < n; i++) secondarySum += arr.get(i).get(n-1-i);

        return Math.abs(primarySum-secondarySum);
    }
}
