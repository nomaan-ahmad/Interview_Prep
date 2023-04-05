package com.nomaan.dsa.binarySearch;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstOccurrence(nums, target), lastOccurrence(nums, target)};
    }

    private int firstOccurrence(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] < target) low = mid+1;
            else if (nums[mid] > target) high = mid-1;
            else {
                if (mid == 0 || nums[mid-1] != target) return mid;
                else high = mid-1;
            }
        }
        return -1;
    }

    private int lastOccurrence(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] < target) low = mid+1;
            else if (nums[mid] > target) high = mid-1;
            else {
                if (mid == nums.length-1 || nums[mid+1] != target) return mid;
                else low = mid+1;
            }
        }
        return -1;
    }
}
