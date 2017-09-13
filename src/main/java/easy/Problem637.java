package easy;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

 Example 1:
 Input:
  3
 / \
 9  20
   /  \
  15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 Note:
 The range of node's value is in the range of 32-bit signed integer.
 */
public class Problem637 {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelCnt = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelCnt; i++) {
                TreeNode n = queue.poll();
                levelSum += n.val;
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            result.add(levelSum / (levelCnt * 1.0));
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l11 = new TreeNode(9);
        TreeNode l12 = new TreeNode(20);
        root.left = l11;
        root.right = l12;
        TreeNode l21 = new TreeNode(15);
        TreeNode l22 = new TreeNode(7);
        l12.left = l21;
        l12.right = l22;

        Problem637 problem637 = new Problem637();
        List<Double> result = problem637.averageOfLevels(root);
        result.forEach(avg -> System.out.println(avg));
    }
}
