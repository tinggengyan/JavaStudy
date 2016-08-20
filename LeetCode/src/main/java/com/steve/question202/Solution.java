package com.steve.question202;

import java.util.HashSet;

/**
 * Created by steveyan on 16-8-19.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(2));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> data = new HashSet<>();
        data.add(1);
        while (!data.contains(n)) {
            data.add(n);
            int next = 0;
            while (n > 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            n = next;
        }
        return n == 1;
    }
}
