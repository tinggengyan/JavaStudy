package com.steve.question171;

//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 

public class Solution {


    public static void main(String[] args) {
        String s = "AAA";
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber(s));
    }

    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;
        for (int i = charArray.length - 1; i > -1; i--) {
            if (charArray.length - 1 - i > 0) {
                result += ((int) charArray[i] - 64) * Math.pow(26, (charArray.length - 1 - i));
            } else {
                result += ((int) charArray[i] - 64);
            }
        }
        return result;
    }

}
