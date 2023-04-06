package com.nomaan.dsa.binarySearch;

// https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        final int n = nums.length;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            boolean left = (mid-1 == -1 || nums[mid-1] <= nums[mid]);
            boolean right = (mid+1 == n || nums[mid] >= nums[mid+1]);

            if (left && right) return mid;
            else if (!left) high = mid-1;
            else low = mid+1;
        }

        return -1;
    }
}
