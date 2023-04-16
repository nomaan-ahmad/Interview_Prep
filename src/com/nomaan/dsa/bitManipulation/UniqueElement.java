package com.nomaan.dsa.bitManipulation;

import java.util.List;

// https://www.hackerrank.com/challenges/lonely-integer/problem
public class UniqueElement {
    public static int lonelyInteger(List<Integer> a) {
        int ans = 0;

        for (int i : a) ans ^= i;

        return ans;
    }
}
