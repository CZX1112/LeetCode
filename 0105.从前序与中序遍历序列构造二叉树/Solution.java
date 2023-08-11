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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int presize = preorder.length, insize = inorder.length;
        if (presize != insize || presize == 0) {
            return null;
        }
        return helper(preorder, 0, presize - 1, inorder, 0, insize - 1);
    }

    public TreeNode helper(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        TreeNode root = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return root;
        }
        // 确定分割点位置
        int divide;
        for (divide = l2; divide <= r2; divide++) {
            if (inorder[divide] == preorder[l1]) {
                break;
            }
        }
        // 目标值左侧有值，存在左子树
        if (divide > l2) {
            root.left = helper(preorder, l1 + 1, l1 + divide - l2, inorder, l2, divide - 1);
        }
        // 第一个值就是目标值，不存在左子树
        else {
            root.left = null;
        }
        // 目标值右侧有值，存在右子树
        if (divide < r2) {
            root.right = helper(preorder, l1 + divide - l2 + 1, r1, inorder, divide + 1, r2);
        }
        return root;
    }
}