/**
 * ychen. Copyright (c) 2018年6月12日.
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author racing
 * @version $Id: E107BinaryTreeLevelOrderTraversalII.java, v 0.1 2018年6月12日 上午11:59:14 racing Exp $
 */
public class E107BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {

    }

    /**
     * Accepted
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        LinkedList<TreeNode> parentLevel = new LinkedList<TreeNode>();
        parentLevel.add(root);
        
        while (!parentLevel.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<Integer>();
            int size = parentLevel.size();
            for (int i = 0; i < size; i ++) {
                TreeNode current = parentLevel.poll();
                currentLevel.add(current.val);
                if (current.left != null) {
                    parentLevel.add(current.left);
                }
                if (current.right != null) {
                    parentLevel.add(current.right);
                }
            }
            result.addFirst(currentLevel);
        }
        return result;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
