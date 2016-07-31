package com.steve.question283;

//For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
//nums should be [1, 3, 12, 0, 0]. 
public class Solution {

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == 0) {
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                }
            }
        }
    }
}
