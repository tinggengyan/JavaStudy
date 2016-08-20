package com.steve.question231;

/**
 * Created by steveyan on 16-8-19.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(1));
    }


    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }

        int res = (int) (Math.log(n) / Math.log(2));
        return n == Math.pow(2, res);
    }
}
