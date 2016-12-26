package com.steve.question371;

// Given a = 1 and b = 2, return 3. not allowed operation + and -

/**
 * 对于位运算来说，将求和、以及进位是分开算的。
 * 求和的时候，不管进位；
 * 对于进位新生成的数字等于再一次进行求和。
 */
public class Solution {

    public static int getSum(int a, int b) {
        int carray = a & b;
        int sum = a ^ b;
        if (carray == 0)
            return sum;

        return getSum(sum, carray << 1);
    }

    public static void main(String[] args) {
        System.out.println(getSum(2, 2));
    }


}
