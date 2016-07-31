package com.steve.question349;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums1[] = new int[]{3, 1, 2};
        int nums2[] = new int[]{1};

        int re[] = solution.intersection(nums1, nums2);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re[i]);
        }

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] m;
        if (nums1.length <= nums2.length) {
            m = nums1;
            nums1 = nums2;
            nums2 = m;
        }

        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] == nums2[i]) {
                    if (!result.contains(nums1[j])) {
                        result.add(nums1[j]);
                    }
                }

            }
        }

        int re[] = new int[result.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = result.get(i);
        }
        return re;
    }

}
