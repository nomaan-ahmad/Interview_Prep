package com.nomaan.dsa.sorting;

import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println(largestNumber(arr));
    }
    public static String largestNumber(int[] nums) {
        String[] values = new String[nums.length];
        for (int i = 0; i < nums.length; i++) values[i] = nums[i] + "";

        Arrays.sort(values, (a,b) -> {
                String s1 = a + "" + b;
                String s2 = b + "" + a;

                return s2.compareTo(s1);
        });

        if (values[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String str : values) sb.append(str);

        return sb.toString();
    }
}
