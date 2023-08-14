import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(result, temp, root, targetSum);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(temp));
        }
        helper(result, temp, root.left, targetSum);
        helper(result, temp, root.right, targetSum);
        temp.remove(temp.size() - 1);
    }
}