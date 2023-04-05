package com.nomaan.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class GenerateSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generate1(res, new ArrayList<>(), 0, nums);
        return res;
    }

    // first approach
    /*
    * This falls into a set of classic problems that can be solved using "pick"- "don't pick" approach.
    * we start with having a choice to pick or not pick from the first element and
    * then, we propagate this choice down the tree.
    *
    * 1- we either pick the element and move ahead ( increment the index ) or,
    * 2- we don't pick the element and move ahead
    *
    */
    private void generate1(List<List<Integer>> res, List<Integer> temp, int idx, int[] nums) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // picking element at index = idx
        temp.add(nums[idx]);
        generate1(res, temp, idx+1, nums);
        temp.remove(temp.size()-1);

        // not picking element
        generate1(res, temp, idx+1, nums);
    }

    // second approach
    private void generate2(List<List<Integer>> res, List<Integer> temp, int idx, int[] nums) {
        res.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            temp.add(nums[i]);
            generate2(res, temp, i+1, nums);
            temp.remove(temp.size()-1);
        }
    }
}
