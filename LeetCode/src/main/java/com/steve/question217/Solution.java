package com.steve.question217;

import java.util.Arrays;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * Created by steveyan on 16-7-31.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[]{0, 1, 1}));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        Arrays.sort(nums);
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
