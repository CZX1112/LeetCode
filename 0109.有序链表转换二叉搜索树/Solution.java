/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    // 法一：先转为数组，再用0108的方法
    // public TreeNode sortedListToBST(ListNode head) {
    //     List<Integer> array = new ArrayList<>();
    //     while (head != null) {
    //         array.add(head.val);
    //         head = head.next;
    //     }
    //     return helper(array, 0, array.size());
    // }

    // public TreeNode helper(List<Integer> array, int left, int right) {
    //     if (left > right) {
    //         return null;
    //     }
    //     int mid = (left + right) / 2;
    //     TreeNode root = new TreeNode(array.get(mid));
    //     root.left = helper(array, left, mid - 1);
    //     root.right = helper(array, mid + 1, right);
    //     return root;
    // }

    // 法二：直接建树
    ListNode ptr;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ptr = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return helper(0, size - 1);
    }

    TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode();
        root.left = helper(left, mid - 1);
        root.val = ptr.val;
        ptr = ptr.next;
        root.right = helper(mid + 1, right);
        return root;
    }
}