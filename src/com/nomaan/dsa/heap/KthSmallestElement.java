package com.nomaan.dsa.heap;

import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7,10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr, 0, 10, 3));
    }
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) pq.add(i);

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}
