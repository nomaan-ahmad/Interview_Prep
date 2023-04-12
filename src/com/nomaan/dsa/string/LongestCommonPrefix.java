package com.nomaan.dsa.string;

// https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1?page=1&status[]=unsolved&curated[]=1&sortBy=submissions
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] arr, int n) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        outer:
        while (true) {
            if (arr[0].length() == idx) break;
            char ch = arr[0].charAt(idx);

            for (int i = 0; i < n; i++) if (arr[i].length() == idx || ch != arr[i].charAt(idx)) break outer;

            sb.append(ch);
            idx++;
        }

        return sb.length() == 0 ? "-1" : sb.toString();
    }
}
