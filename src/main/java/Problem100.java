import utils.TreeNode;

/**
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (p == null && q != null)) return false;
        else if (p != null && q != null && p.val != q.val) return false;
        else {
            boolean leftSameTree = isSameTree(p.left, q.left);
            boolean rightSameTree = isSameTree(p.right, q.right);
            return leftSameTree && rightSameTree;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode l11 = new TreeNode(2);
        TreeNode l12 = new TreeNode(3);
        root1.left = l11;
        root1.right = l12;

        TreeNode root2 = new TreeNode(1);
        root2.left = l11;

        Problem100 problem100 = new Problem100();
        boolean result = problem100.isSameTree(root1, root2);
        System.out.println(result);
    }
}
