package com.steve.question326;

/**
 * 判断一个数
 *
 * Created by steveyan on 16-8-18.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(9));

    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        long round = Math.round(Math.log(n) / Math.log(3));
        return Math.pow(3, round) == n;
    }

}
