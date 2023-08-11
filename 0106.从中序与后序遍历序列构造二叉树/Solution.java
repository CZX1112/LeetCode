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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int insize = inorder.length, postsize = postorder.length;
        if (insize != postsize || insize == 0) {
            return null;
        }
        return helper(inorder, 0, insize - 1, postorder, 0, postsize - 1);
    }

    public TreeNode helper(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        TreeNode root = new TreeNode(postorder[r2]);
        if (l2 == r2) {
            return root;
        }
        // 确定分割点位置
        int divide;
        for (divide = l1; divide <= r1; divide++) {
            if (inorder[divide] == postorder[r2]) {
                break;
            }
        }
        // 目标值左侧有值，存在左子树
        if (divide > l1) {
            root.left = helper(inorder, l1, divide - 1, postorder, l2, divide + l2 - l1- 1);
        }
        // 第一个值就是目标值，不存在左子树
        else {
            root.left = null;
        }
        // 目标值右侧有值，存在右子树
        if (divide < r1) {
            root.right = helper(inorder, divide + 1, r1, postorder, divide + l2 - l1, r2 - 1);
        }
        // 最后一个值是目标值，不存在右子树
        else {
            root.right = null;
        }
        return root;
    }
}