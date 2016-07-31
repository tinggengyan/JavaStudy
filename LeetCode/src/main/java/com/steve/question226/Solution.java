package com.steve.question226;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
}
