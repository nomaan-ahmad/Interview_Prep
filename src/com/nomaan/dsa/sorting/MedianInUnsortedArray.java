package com.nomaan.dsa.sorting;

import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/find-the-median/problem
public class MedianInUnsortedArray {
    public static void main(String[] args) {
        Integer[] arr = {0,1, 2, 4, 6,5, 3};
        System.out.println(findMedian(Arrays.asList(arr)));
    }

    // Solving median of an array using quick select
    public static int findMedian(List<Integer> arr) {
        int n = arr.size();
        if (n==1) return arr.get(0);

        return arr.get(recurse(arr, 0, n-1));
    }

    private static int recurse(List<Integer> arr, int left, int right) {
        int pivot = findPivot(arr, left, right);

        if (pivot == arr.size()/2) return pivot;
        else if (pivot < arr.size()/2) return recurse(arr, pivot+1, right);
        else return recurse(arr, left, pivot-1);
    }
    private static int findPivot(List<Integer> arr, int left, int right) {
        int num = arr.get(right);
        int pivot = left-1;

        while (left < right) {
            if (arr.get(left) < num) {
                pivot++;
                swap(arr, left, pivot);
            }
            left++;
        }

        pivot++;
        swap(arr, right, pivot);
        return pivot;
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
