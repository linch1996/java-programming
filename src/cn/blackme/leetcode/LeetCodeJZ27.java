package cn.blackme.leetcode;

import cn.blackme.leetcode.definition.TreeNode;

public class LeetCodeJZ27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
