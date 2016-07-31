package com.steve.question344;

/**
 * Given s = "hello", return "olleh".
 *
 * @author steveyan
 */
public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
        so.reverseString("Hello");
    }

    public String reverseString(String s) {
        char[] split = s.toCharArray();
        int length = split.length;
        char[] split2 = new char[length];
        for (int i = 0; i < length; i++) {
            split2[length - 1 - i] = split[i];
        }
        return String.valueOf(split2);
    }

}
