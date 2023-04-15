package com.nomaan.dsa.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B','B','B'};
        System.out.println(leastInterval(tasks,0));
    }
    /* First approach using Task class */
    private static class Task {
        char task;
        int lastOccurrence;

        Task(char _task, int _lastOccurrence) {
            task = _task;
            lastOccurrence = _lastOccurrence;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for (char ch : tasks) frequency[ch - 'A']++;

        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> frequency[b.task - 'A'] - frequency[a.task - 'A']);
        for (int i = 0; i < 26; i++) if (frequency[i] > 0) pq.add(new Task((char)(i+65), Integer.MIN_VALUE));

        int time = 0;
        while (!pq.isEmpty()) {
            List<Task> aux = new ArrayList<>();
            Task t = null;
            while (!pq.isEmpty()) {
                t = pq.poll();
                if (t.lastOccurrence + n < time) break;
                aux.add(t);
            }

            if (t.lastOccurrence + n < time) {
                frequency[t.task - 'A']--;
                t.lastOccurrence = time;
                if (frequency[t.task - 'A'] > 0) pq.add(t);
            }

            pq.addAll(aux);

            time++;
        }

        return time;
    }

    /* Second approach (more efficient) */
    public static int leastInterval2(char[] tasks, int n) {
        int[] frequency = new int[26];
        for (char ch : tasks) frequency[ch - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i : frequency) if(i != 0) pq.add(i);

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> aux = new ArrayList<>();

            // loop is important to understand -- think thoroughly
            for (int i = 0; i <= n; i++) {
                if (pq.isEmpty()) {
                    if (!aux.isEmpty()) time += (n-i);
                    break;
                }

                int temp = pq.poll();
                if (temp - 1 > 0) aux.add(temp-1);
                time++;
            }

            pq.addAll(aux);
        }
        return time;
    }
}
