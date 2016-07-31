package com.steve.question169;

import java.util.HashMap;

// Given an array of size n, find the majority element.
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always exist in the array.
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 11, 11, 11, 11, 1, 7, 8, 9, 11, 11};
        System.out.println(solution.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> data = new HashMap<>();
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            Integer integer = data.get(nums[i]);
            int value = 0;
            if (integer == null) {
                value = 1;
            } else {
                value = integer + 1;
            }
            data.put(nums[i], value);
            if (value > nums.length / 2) {
                result = nums[i];
            }
        }
        return result;
    }

}
