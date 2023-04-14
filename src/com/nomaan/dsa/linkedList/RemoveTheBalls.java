package com.nomaan.dsa.linkedList;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/546ea68f97be7283a04ddcc8057e09b46a686471/1
public class RemoveTheBalls {
    public static void main(String[] args) {
        int n = 4;
        int[] color = {0,2,4,5,6,8,8,6,5};
        int[] radius = {1,3,4,5,7,8,8,7,5};
        System.out.println(findLengthFirstApproach(n, color, radius));
        System.out.println(findLengthSecondApproach(n, color, radius));
    }

    // first approach using Doubly LinkedList
    public static int findLengthFirstApproach(int N, int[] color, int[] radius) {
        List<Integer> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) dq.add(i);

        ListIterator<Integer> itr = dq.listIterator();

        while (itr.hasNext()) {
            int a = itr.next();
            int b;
            if (itr.hasNext()) b = itr.next();
            else break;

            if (color[a] == color[b] && radius[a] == radius[b]) {
                itr.remove();
                itr.previous();
                itr.remove();
            }

            if (itr.hasPrevious()) itr.previous();
        }

        return dq.size();
    }

    // second approach using stack
    private static int findLengthSecondApproach(int N, int[] color, int[] radius) {
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (stk.isEmpty()) stk.push(i);
            else {
                int top = stk.peek();
                if (color[top] == color[i] && radius[top] == radius[i]) stk.pop();
                else stk.add(i);
            }
        }

        return stk.size();
    }
}
