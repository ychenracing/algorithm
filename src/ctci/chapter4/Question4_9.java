package ctci.chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 打印出路径和为某一数值的所有节点
 * 
 * @author racing
 * @version $Id: Question4_9.java, v 0.1 Sep 21, 2015 12:04:26 AM racing Exp $
 */
public class Question4_9 {

    static class Node {
        Node left;
        Node right;
        int  value;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(8);
        Node child1l = new Node(8);
        Node child1r = new Node(8);
        Node child2l = new Node(8);
        Node child2r = new Node(8);
        Node child3r = new Node(8);
        Node child4l = new Node(8);
        node.left = child1l;
        node.right = child1r;
        child1l.left = child2l;
        child1l.right = child2r;
        child2r.right = child3r;
        child3r.left = child4l;
        bst(node);
    }

    public static void bst(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        if (node == null)
            return;
        queue.add(node);

        int k = 0;
        int minDepth = Integer.MAX_VALUE;
        int maxDepth = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int num = queue.size();
            k++;
            for (int i = 0; i < num; i++) {
                Node cur = queue.remove();
                if (cur.left == null && cur.right == null) {
                    if (k < minDepth)
                        minDepth = k;
                    if (k > maxDepth)
                        maxDepth = k;
                    continue;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        System.out.println(maxDepth - minDepth);
    }

    public static void solve(Node cur, int sum, int[] path, int depth) {
        if (cur == null) {
            return;
        }

        path[depth] = cur.value;

        int t = 0;
        for (int i = depth; i >= 0; i--) {
            t += path[i];
            if (t == sum) {
                print(path, depth, i);
            }
        }

        solve(cur.left, sum, path, depth + 1);
        solve(cur.right, sum, path, depth + 1);

        path[depth] = Integer.MAX_VALUE;
    }

    public static void print(int[] path, int buttom, int top) {
        for (int i = top; i <= buttom; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static void findSum(Node tree, int sum) {
        int depth = depth(tree);
        int[] path = new int[depth];
        solve(tree, sum, path, depth);
    }

    public static int depth(Node node) {
        if (node == null)
            return 0;
        else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }
}
