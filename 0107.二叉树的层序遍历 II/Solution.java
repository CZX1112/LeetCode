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
import java.util.Collections;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> myqueue = new ArrayDeque<>();
        myqueue.offer(root);
        while (!myqueue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = myqueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode nownode = myqueue.poll();
                temp.add(nownode.val);
                if (nownode.left != null) {
                    myqueue.add(nownode.left);
                }
                if (nownode.right != null) {
                    myqueue.add(nownode.right);
                }
            }
            result.add(temp);
        }
        Collections.reverse(result);
        return result;
    }
}