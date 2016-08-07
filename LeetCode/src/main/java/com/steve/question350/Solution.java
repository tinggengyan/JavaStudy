package com.steve.question350;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Created by steveyan on 16-8-6.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5,6};
        int[] b = {2, 2, 3, 4, 4, 5,6};

        int[] intersect = solution.intersect(a, b);

        for (int i : intersect) {
            System.out.println(i);
        }
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();

        if (nums1 == null || nums2 == null) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] a;
        int[] b;

        if (nums1.length > nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            a = nums2;
            b = nums1;
        }

        int i = 0;
        int j = 0;

        for (; i < a.length && j < b.length; ) {
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else if (a[i] == b[j]) {
                result.add(a[i]);
                i++;
                j++;
            }
        }

        int[] rr = new int[result.size()];
        for (int i2 = 0; i2 < result.size(); i2++) {
            rr[i2] = result.get(i2);
        }

        return rr;
    }
}
