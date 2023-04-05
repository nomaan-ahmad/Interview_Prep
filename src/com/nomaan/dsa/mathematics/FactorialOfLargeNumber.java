package com.nomaan.dsa.mathematics;

import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
public class FactorialOfLargeNumber {
    public static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (N < 2) return ans;

        for (int num = 2; num <= N; num++) {
            int carry = 0;
            for (int i = 0; i < ans.size(); i++) {
                int mul = num * ans.get(i) + carry;
                ans.set(i, mul % 10);
                carry = mul/10;
            }

            while (carry > 0) {
                ans.add(carry%10);
                carry /= 10;
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
