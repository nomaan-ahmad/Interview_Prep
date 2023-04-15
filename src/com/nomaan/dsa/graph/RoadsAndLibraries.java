package com.nomaan.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/torque-and-development/problem
public class RoadsAndLibraries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 17;
        List<List<Integer>> cities = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            List<Integer> temp = new ArrayList<>();
            temp.add(a);
            temp.add(b);

            cities.add(temp);
        }

        System.out.println(roadsAndLibraries(n, 0, 0, cities));
    }
    /*
    1 2
    1 3
    3 4
    3 5
    3 6
    6 7
    8 9
    9 10
    10 8
    11 13
    13 15
    13 14
    13 12
    15 14
    16 17
    */
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (List<Integer> road : cities) {
            adj.get(road.get(0)).add(road.get(1));
            adj.get(road.get(1)).add(road.get(0));
        }

        List<Integer> connectedComponent = new ArrayList<>();
        boolean[] isVisited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                int numOfNodes = dfs(i, adj, isVisited);
                connectedComponent.add(numOfNodes);
            }
        }

        long price = 0;

        for (int totalNodes : connectedComponent) {
            int first = c_lib + (totalNodes-1)*c_road;
            int second = totalNodes*c_lib;

            price += Math.min(first, second);
        }

        return price;
    }

    private static int dfs (int node, List<List<Integer>> adj, boolean[] isVisited) {
        if (isVisited[node]) return 0;

        isVisited[node] = true;
        int count = 1;
        for (int neighbour : adj.get(node)) {
            count += dfs(neighbour, adj, isVisited);
        }

        return count;
    }
}
