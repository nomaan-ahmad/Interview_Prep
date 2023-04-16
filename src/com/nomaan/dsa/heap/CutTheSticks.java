package com.nomaan.dsa.heap;

import java.util.*;

// https://www.hackerrank.com/challenges/cut-the-sticks/problem
public class CutTheSticks {
    public static void main(String[] args) {
        Integer[] arr = {5,4,4,2,2,8};

        System.out.println(cutTheSticks(Arrays.asList(arr)));
    }
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();

        pq.addAll(arr);

        while (!pq.isEmpty()) {
            int size = pq.size();

            ans.add(size);

            if (size == 1) break;
            else {
                int temp = pq.poll();

                Stack<Integer> stk = new Stack<>();

                for (int i = 1; i < size; i++) {
                    int a = pq.poll() - temp;

                    if (a > 0) stk.add(a);
                }

                int stk_size = stk.size();
                for (int i = 0; i < stk_size; i++) pq.add(stk.pop());

            }
        }

        return ans;
    }
}
