package easy;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:

 Input:
  5
 / \
 3   6
 / \   \
 2   4   7

 Target = 9

 Output: True

 Example 2:

 Input:
  5
 / \
 3   6
 / \   \
 2   4   7

 Target = 28

 Output: False

 */
public class Problem653 {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        get(root, map);

        for (int num: map.keySet()) {
            int target = k - num;
            if (map.containsKey(target)) {
                if (num != target) {
                    return true;
                }
                else {
                    return map.get(num) > 1;
                }
            }
        }

        return false;
    }

    private void get(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        get(root.left, map);
        get(root.right, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l11 = new TreeNode(3);
        TreeNode l12 = new TreeNode(6);
        root.left = l11;
        root.right = l12;
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(4);
        l11.left = l21;
        l11.right = l22;
        TreeNode l23 = new TreeNode(7);
        l12.right = l23;

        Problem653 problem653 = new Problem653();
        boolean result = problem653.findTarget(root, 9);
        System.out.println(result);
    }
}
