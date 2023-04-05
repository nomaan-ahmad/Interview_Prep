package com.nomaan.dsa.matrix;

import java.util.ArrayList;

// https://www.codingninjas.com/codestudio/problems/zero-matrix_1171153
public class SetMatrixZeroes {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        boolean rowFlag = false; // if first row contains zero or not
        boolean colFlag = false; // if first column contains zero or not

        // for first row
        for (int i : matrix.get(0))
            if (i == 0) {
                rowFlag = true;
                break;
            }

        // for first column
        for (ArrayList<Integer> a : matrix)
            if (a.get(0) == 0) {
                colFlag = true;
                break;
            }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(0).set(j, 0);
                    matrix.get(i).set(0,0);
                }
            }
        }

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                    matrix.get(i).set(j,0);
                }
            }

        if (rowFlag) {
            for (int i = 0; i < m; i++)
                matrix.get(0).set(i,0);
        }

        if (colFlag) {
            for (int i = 0; i < n; i++)
                matrix.get(i).set(0,0);
        }

        return matrix;
    }
}
