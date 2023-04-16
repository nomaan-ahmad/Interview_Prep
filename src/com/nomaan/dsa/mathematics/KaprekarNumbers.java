package com.nomaan.dsa.mathematics;

// https://www.hackerrank.com/challenges/kaprekar-numbers/problem
public class KaprekarNumbers {
    public static void main(String[] args) {
        kaprekarNumbers(1, 99999);
    }

    public static void kaprekarNumbers(int p, int q) {
        boolean flag = false;

        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                flag = true;

                System.out.print(i + " ");
            }
        }

        if (!flag) System.out.println("INVALID RANGE");
    }

    /*
        1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
    */
    private static boolean isKaprekar(int n) {
        long digit = (int) Math.floor(Math.log10(n)) + 1;
        long square = (long) n * n;

        long right = 0;
        long power = 1;
        for (int i = 0; i < digit; i++) {
            right += (square%10) * power;
            square /= 10;
            power *= 10;
        }

        return (square+right == n);
    }
}
