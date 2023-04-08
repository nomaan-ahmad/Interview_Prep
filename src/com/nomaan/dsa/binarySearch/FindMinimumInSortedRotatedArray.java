package com.nomaan.dsa.binarySearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInSortedRotatedArray {
    public int findMin(int[] nums) {
        final int n = nums.length;
        if (n == 1 || nums[0] < nums[n-1]) return nums[0];

        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] >= nums[0]) low = mid + 1;
            else {
                if (nums[mid-1] < nums[mid]) high = mid - 1;
                else return nums[mid];
            }
        }

        return -1;
    }
}
