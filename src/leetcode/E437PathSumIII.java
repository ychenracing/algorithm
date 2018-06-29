/**
 * ychen. Copyright (c) 2018年6月29日.
 */
package leetcode;

/**
 * 
 * @author racing
 * @version $Id: E437PathSumIII.java, v 0.1 2018年6月29日 上午9:49:54 racing Exp $
 */
public class E437PathSumIII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode three = new TreeNode(3);
        three.left = new TreeNode(3);
        three.right = new TreeNode(-2);
        TreeNode five = new TreeNode(5);
        five.left = three;
        TreeNode two = new TreeNode(2);
        two.right = new TreeNode(1);
        five.right = two;
        TreeNode nthree = new TreeNode(-3);
        nthree.right = new TreeNode(11);
        root.left = five;
        root.right = nthree;
        System.out.println(pathSum(root, 8));
        
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int cur = sum - root.val;
        return (cur == 0 ? 1 : 0) + pathSum2(root.left, cur) + pathSum(root.left, sum)
               + pathSum2(root.right, cur) + pathSum(root.right, sum);
    }
    
    public static int pathSum2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int cur = sum - root.val;
        return (cur == 0 ? 1 : 0) + pathSum2(root.left, cur)
               + pathSum2(root.right, cur);
    }
    

    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
