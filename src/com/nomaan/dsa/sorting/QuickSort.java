package com.nomaan.dsa.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,8,9,1,2,7,4,9,6};
        int n = nums.length;

        sort(nums, 0, n-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivot = partition(nums, left, right);

        sort(nums, left, pivot-1);
        sort(nums, pivot+1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int num = nums[right];
        int pivot = left-1;

        while (left < right) {
            if (nums[left] < num) {
                pivot++;
                swap(nums, pivot, left);
            }
            left++;
        }

        pivot++;
        swap(nums, pivot, right);
        return pivot;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
