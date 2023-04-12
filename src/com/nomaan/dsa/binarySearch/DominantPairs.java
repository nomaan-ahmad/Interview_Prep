package com.nomaan.dsa.binarySearch;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/2a1c11024ceae36363fc405e07f2fa3e2f896ef0/1
public class DominantPairs {
    public static int dominantPairs(int n, int[] arr) {
        Arrays.sort(arr, n/2, n);

        int count = 0;
        for (int i = 0; i < n/2; i++) {
            int idx = binarySearch(arr, n, i);
            if (idx == -1) continue;
            else {
                count += idx - n/2 + 1;
            }
        }

        return count;
    }

    private static int binarySearch (int[] arr, int n, int i) {
        int low = n/2, high = n-1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[i] >= (5 * arr[mid])) {
                if (mid == n-1 || (arr[mid+1] * 5) > arr[i]) return mid;
                else low = mid + 1;
            } else high = mid-1;
        }
        return -1;
    }
}
