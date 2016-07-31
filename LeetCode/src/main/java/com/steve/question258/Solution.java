package com.steve.question258;

//Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it. 

public class Solution {

    public static void main(String[] args) {

    }

    public int addDigits(int num) {
        while (num >= 10) {
            num = (num / 10) + num % 10;
        }
        return num;
    }

}
