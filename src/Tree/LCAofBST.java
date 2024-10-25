package Tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class LCAofBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * p and q both exists in BST
     * p != q
     * if parent(root) value is greater than both p and q then recurse left because p and q should in left subtree
     * if parent(root) value is less than both p and q then recurse right because p and q should in right subtree
     */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        // both p and q greater than root recurse right
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestorBST(root.right, p, q);
            // both p and q greater than root recurse left
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestorBST(root.left, p, q);
        } else {
            return root;
        }
    }

}
