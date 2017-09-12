import utils.TreeNode;

/**
 Invert a binary tree.

   4
 /   \
 2     7
 / \   / \
 1   3 6   9

 to

   4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
public class Problem226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);

        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode l11 = new TreeNode(2);
        TreeNode l12 = new TreeNode(7);
        root.left = l11;
        root.right = l12;
        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = new TreeNode(3);
        l11.left = l21;
        l11.right = l22;
        TreeNode l23 = new TreeNode(6);
        TreeNode l24 = new TreeNode(9);
        l12.left = l23;
        l12.right = l24;

        Problem226 problem226 = new Problem226();
        root = problem226.invertTree(root);
        problem226.inorder(root);
    }
}
