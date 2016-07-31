package com.steve.question292;

/**
 * 两个人，每次可以移动1-3个砖头，问成功的概率;
 * 分割出来的数字的和不能被2,3,4,5,6整除
 *
 * @author steveyan
 */
public class Soulution {

    public static void main(String[] args) {
        Soulution so = new Soulution();
        System.out.println(so.canWinNim(5));
    }

    public boolean canWinNim(int n) {
        boolean r = (n % 4 != 0);
        return r;
    }
}
