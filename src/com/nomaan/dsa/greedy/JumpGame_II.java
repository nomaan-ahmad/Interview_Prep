package com.nomaan.dsa.greedy;

// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
public class JumpGame_II {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,6,7};
        System.out.println(minJumps(arr));
    }
    static int minJumps(int[] arr){
        final int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] == 0) return -1;

        int left = 0, right = 0;

        int count = 0;
        while (right < n-1) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) max = Math.max(i+arr[i], max);

            left = right + 1;
            if (max <= right) return -1;
            right = max;
            count++;
        }

        return count;
    }
}
