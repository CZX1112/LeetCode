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
    // 递归法
    public ListNode swapPairs(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // swapPairs(ListNode head) 的意义就是两两翻转链表中的节点+返回翻转后的新的头结点
        // 我们知道翻转后新的头结点必然是第二个节点
        // 举例子:1->2->3->4 翻转后:2->1->4->3
        ListNode newHead = head.next;   // 2
        // 此时tmpHead为:4->3
        ListNode tempHead = swapPairs(newHead.next);
        // 而前面的还粘连着:1->2->(3)  4->3
        // 此时再让1->4 此时链表为:2->(3) 1->4->3
        head.next = tempHead;
        // 再将2指向1即可 此时链表为:2->1->4->3 已经完成翻转
        newHead.next = head;
        // 返回新的头结点
        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 创建测试输入
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // 调用方法进行两两翻转
        ListNode swappedList = solution.swapPairs(head);

        // 打印翻转后的链表
        printList(swappedList);
    }

    // 辅助方法：打印链表的值
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}