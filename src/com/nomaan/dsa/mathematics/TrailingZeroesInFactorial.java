package com.nomaan.dsa.mathematics;

// https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134
public class TrailingZeroesInFactorial {
    public static int trailingZeroes(int N){
        int res = 0;

        for (int i = 5; i <= N; i = i*5) {
            res += Math.floorDiv(N, i);
        }

        return res;
    }
}
