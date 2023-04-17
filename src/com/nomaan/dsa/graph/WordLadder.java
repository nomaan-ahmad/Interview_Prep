package com.nomaan.dsa.graph;

import java.util.*;

// https://leetcode.com/problems/word-ladder/
public class WordLadder {
    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};
        String begin = "hit";
        String end = "cog";

        System.out.println(ladderLength(begin, end, Arrays.asList(words)));
    }


    // Solved it using Breadth First Search
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) return 0;

        int len = beginWord.length();

        HashSet<String> isVisited = new HashSet<>();
        isVisited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            // Iterating for each element at current level
            for (int i = 0; i < size; i++) {
                StringBuilder word = new StringBuilder(Objects.requireNonNull(q.poll()));

                if (endWord.equals(word.toString())) return level;
                // Iterating on each index of element
                for (int j = 0; j < len; j++) {

                    char ch = word.charAt(j);

                    // Iterating over each lower case english alphabet
                    for (int k = 0; k < 26; k++) {
                        if (!(('a' + k) == ch)) {
                            word.setCharAt(j, (char) ('a' + k));
                            String temp = word.toString();
                            if (words.contains(temp) && !isVisited.contains(temp)) {
                                q.add(temp);
                                isVisited.add(temp);
                            }
                        }
                    }

                    word.setCharAt(j, ch);
                }
            }

            level++;
        }

        return -1;
    }
}
