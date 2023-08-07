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
import java.util.List;
import java.util.ArrayList;

class Solution {
    // 法一：递归法
    // public boolean isValidBST(TreeNode root) {
    //     return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }

    // public boolean helper(TreeNode root, long lower, long upper) {
    //     if (root == null) {
    //         return true;
    //     }
    //     if (root.val <= lower || root.val >= upper) {
    //         return false;
    //     }
    //     return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    // }

    // 法二：中序遍历法
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        InOrder(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void InOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        InOrder(root.left, result);
        result.add(root.val);
        InOrder(root.right, result);
    }
}