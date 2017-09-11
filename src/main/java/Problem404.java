import utils.TreeNode;

/*
Find the sum of all left leaves in a given binary tree.

    3
   / \
  9  20
    /  \
   16   7
There are two left leaves in the binary tree, with values 9 and 16 respectively. Return 25.
 */
public class Problem404 {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root, false);
        return sum;
    }

    private void sumOfLeftLeaves(TreeNode root, boolean fromLeft) {
        if (root == null) return;
        if (fromLeft && root.left == null && root.right == null) sum += root.val;
        else {
            sumOfLeftLeaves(root.left, true);
            sumOfLeftLeaves(root.right, false);
        }
    }

    public static void main(String[] args) {
        Problem404 problem404 = new Problem404();
        TreeNode root = new TreeNode(3);
        TreeNode l11 = new TreeNode(9);
        TreeNode l12 = new TreeNode(20);
        TreeNode l21 = new TreeNode(16);
        TreeNode l22 = new TreeNode(7);
        root.left = l11;
        root.right = l12;
        l12.left = l21;
        l12.right = l22;

        int sum = problem404.sumOfLeftLeaves(root);
        System.out.println(sum);
    }
}
