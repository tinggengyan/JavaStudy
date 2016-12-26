package com.steve.question461;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * <p>0 ≤ x, y < 231.
 * Created by yantinggeng on 2016/12/26.
 */
public class Solution {
    public static int hammingDistance(int x, int y) {
        if (x >= 0 && x < Math.pow(2, 31) && y >= 0 && y < Math.pow(2, 31)) {
            int a = x ^ y;
            int num = 0;
            while (a != 0) {
                if ((a & 1) == 1) {
                    num++;
                }
                a = a >> 1;
            }
            return num;
        } else return 0;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1577962638, 1727613287));
    }
}