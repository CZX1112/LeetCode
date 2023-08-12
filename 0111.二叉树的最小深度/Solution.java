/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    // 法一：深度优先搜索
    // public int minDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftDepth = minDepth(root.left);
    //     int rightDepth = minDepth(root.right);
    //     // 首先需要保证有左右子树，即高度不能为0
    //     if (leftDepth == 0 || rightDepth == 0) {
    //         return leftDepth + rightDepth + 1;
    //     }
    //     return Math.min(leftDepth, rightDepth) + 1;
    // }

    // 法二：广度优先搜索
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> myqueue = new ArrayDeque<>();
        myqueue.offer(root);
        while (!myqueue.isEmpty()) {
            depth++;
            int size = myqueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode nownode = myqueue.poll();
                if (nownode.left == null && nownode.right == null) {
                    return depth;
                }
                if (nownode.left != null) {
                    myqueue.offer(nownode.left);
                }
                if (nownode.right != null) {
                    myqueue.offer(nownode.right);
                }
            }
        }
        return depth;
    }
}