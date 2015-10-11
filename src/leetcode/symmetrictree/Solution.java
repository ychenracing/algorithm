/**
 * ychen.
 * Copyright (c) Oct 11, 2015.
 */
package leetcode.symmetrictree;

/**
 * 
 * @author racing
 * @version $Id: Solution.java, v 0.1 Oct 11, 2015 10:05:34 PM racing Exp $
 */
public class Solution {

    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);

    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null && right != null || left != null && right == null)
            return false;
        if (left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
