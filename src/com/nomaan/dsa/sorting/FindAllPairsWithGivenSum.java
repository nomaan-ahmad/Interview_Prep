package com.nomaan.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindAllPairsWithGivenSum {
    private static class pair  {
        long first, second;
        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + "," + second +")";
        }
    }

    public static pair[] allPairs( long[] A, long[] B, long N, long M, long X) {
        HashSet<Long> hs = new HashSet<>();
        for (long i : A) hs.add(i);

        List<pair> res = new ArrayList<>();

        for (long i : B) if (hs.contains(X - i)) res.add(new pair(X - i, i));


        res.sort( (a,b) -> (int) (a.first - b.first));
        return res.toArray(new pair[0]);
    }

    public static void main(String[] args) {
        long[] a = {1, 2, 4, 5, 7};
        long[] b = {5, 6, 3, 4, 8};
        long x = 9;
        System.out.println(Arrays.toString(allPairs(a,b, a.length, b.length, x)));
    }
}
