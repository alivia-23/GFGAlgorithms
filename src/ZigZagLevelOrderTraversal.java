import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ZigZagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * Time Complexity - O(n)
     * Space complexity - O(n)
     */

    public List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left = true;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                if (!left) {
                    curLevel.add(0, node.val);
                } else {
                    curLevel.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(curLevel);
            left = !left;
        }
        return result;
    }
}
