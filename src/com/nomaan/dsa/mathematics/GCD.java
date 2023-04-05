package com.nomaan.dsa.mathematics;

// https://practice.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1
public class GCD {
    public int gcd(int A , int B) {
        if (B==0) return A;

        return gcd(B, A % B);
    }
}
