package com.nomaan.dsa.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) li.add(sc.nextInt());

        System.out.println(countingSort(li));
    }
    public static List<Integer> countingSort(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int[] count = new int[max-min+1];

        for (int i : arr) count[i-min]++;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++)
                    ans.add(i+min);
            }
        }

        return ans;
    }
}
