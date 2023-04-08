package com.nomaan.dsa.mathematics;

public class FastExponentiation {
    public long power(int n, int x) {
        if (x == 0) return 1;
        if (x == 1) return n;

        long aux = power(n, x/2);
        if (x % 2 == 0)
            return aux * aux;
        else return aux * aux * n;
    }
}
