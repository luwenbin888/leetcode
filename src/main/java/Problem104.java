import utils.TreeNode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Problem104 {
    public int maxDepth(TreeNode root) {
        int depth = method2(root);
        return depth;
    }

    // recursive method
    private int method1(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftTreeDepth = maxDepth(root.left);
            int rightTreeDepth = maxDepth(root.right);
            return 1 + Math.max(leftTreeDepth, rightTreeDepth);
        }
    }

    // breath first
    private int method2(TreeNode root) {
        int layer = 0;
        if (root == null) return 0;
        Queue<TreeNode> nodes = new ConcurrentLinkedQueue<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int layerCnt = nodes.size();
            while (layerCnt-- > 0) {
                TreeNode node = nodes.poll();
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
            // add one layer
            layer++;
        }

        return layer;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l11 = new TreeNode(2);
        TreeNode l12 = new TreeNode(3);
        root.left = l11;
        root.right = l12;
        TreeNode l21 = new TreeNode(4);
        TreeNode l31 = new TreeNode(5);
        l11.left = l21;
        l21.left = l31;

        Problem104 problem104 = new Problem104();
        int depth = problem104.maxDepth(root);
        System.out.println(depth);
    }
}
