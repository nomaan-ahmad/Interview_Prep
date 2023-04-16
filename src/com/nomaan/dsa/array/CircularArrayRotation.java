package com.nomaan.dsa.array;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/circular-array-rotation/problem
public class CircularArrayRotation {
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> ans = new ArrayList<>();

        int n = a.size();
        k = k % n;

        if (k !=  0) {
            reverse(a, 0, n-1-k);
            reverse(a, n-k, n-1);
            reverse(a, 0, n-1);
        }

        for (int i : queries) ans.add(a.get(i));

        return ans;
    }

    private static void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);

            start++;
            end--;
        }
    }
}
