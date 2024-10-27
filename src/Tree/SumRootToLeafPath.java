package Tree;

public class SumRootToLeafPath {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        return calculatePathSum(root, 0);
    }

    private int calculatePathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return calculatePathSum(root.left, sum) + calculatePathSum(root.right, sum);

    }
}
