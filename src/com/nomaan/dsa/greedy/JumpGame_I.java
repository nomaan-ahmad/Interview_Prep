package com.nomaan.dsa.greedy;

// https://leetcode.com/problems/jump-game/
public class JumpGame_I {

    // First approach (using Valley peak approach)
    public boolean canJumpApproach1(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;

        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return maxReach >= nums.length-1;
    }

    // Greedy (most optimal)
    public boolean canJumpApproach2(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;

        int goal = nums.length-1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] + i >= goal) goal = i;
        }

        return goal == 0;
    }
}
