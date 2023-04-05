package com.nomaan.dsa.binarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = searchPivot(nums);

        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length-1);
        }else {
            if (target >= nums[0]) return binarySearch(nums, target, 0, pivot);
            else return binarySearch(nums, target, pivot+1, nums.length-1);
        }
    }

    private int binarySearch(int[] nums, int target, int low , int high){
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] < target) low = mid+1;
            else if (nums[mid] > target) high = mid-1;
            else return mid;
        }

        return -1;
    }
    private int searchPivot(int[] nums) {
        if (nums[0] <= nums[nums.length-1]) return -1;

        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] < nums[0]) high = mid-1;
            else {
                if (nums[mid+1] < nums[mid]) return mid;
                else low = mid+1;
            }
        }
        return -1;
    }
}
