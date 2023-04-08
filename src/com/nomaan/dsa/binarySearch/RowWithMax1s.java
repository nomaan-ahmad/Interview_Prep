package com.nomaan.dsa.binarySearch;

// https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
public class RowWithMax1s {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(arr, arr.length, arr[0].length));
    }

    private static int rowWithMax1s(int[][] arr, int n, int m) {
        int maxCount1s = Integer.MIN_VALUE;
        int resultRow = -1;

        for (int i = 0; i < n; i++) {
            int count1s = m - count0s(arr, i, m);
            if (count1s == m) return i;
            else if (maxCount1s < count1s) {
                resultRow = i;
                maxCount1s = count1s;
            }
        }

        return maxCount1s == 0 ? -1 : resultRow;
    }

    private static int count0s(int[][] arr, int row, int m) {
        int low = 0, high = m-1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[row][mid] == 1) {
                if (mid == 0 || arr[row][mid-1] == 0) return mid;
                else high = mid-1;
            }else low = mid + 1;
        }

        return m;
    }
}
