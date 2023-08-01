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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // 创建测试链表 [1, 1, 2, 2, 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(head);

        // 输出结果链表
        StringBuilder sb = new StringBuilder();
        while (result != null) {
            sb.append(result.val).append(" -> ");
            result = result.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}