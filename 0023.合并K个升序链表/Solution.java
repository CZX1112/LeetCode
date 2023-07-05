import java.util.PriorityQueue;

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
    // 法一：优先队列PriorityQueue
    // public ListNode mergeKLists(ListNode[] lists) {
    //     PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
    //     for (ListNode node : lists) {
    //         if (node != null) {
    //             pq.offer(node);
    //         }
    //     }
    //     ListNode dummyHead = new ListNode(0);
    //     ListNode tail = dummyHead;
    //     while (!pq.isEmpty()) {
    //         ListNode minNode = pq.poll();
    //         tail.next = minNode;
    //         tail = minNode;
    //         if (minNode.next != null) {
    //             pq.offer(minNode.next);
    //         }
    //     }
    //     return dummyHead.next;
    // }

    // 法二：分治合并
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode prehead = new ListNode(0);
        ListNode prev = prehead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                prev.next = a;
                a = a.next;
            }
            else {
                prev.next = b;
                b = b.next;
            }
            prev = prev.next;
        }
        prev.next = a == null ? b : a;
        return prehead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 创建测试输入
        ListNode[] lists = new ListNode[3];

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        lists[0] = list1;

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        lists[1] = list2;

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        lists[2] = list3;

        // 调用方法进行合并
        ListNode mergedList = solution.mergeKLists(lists);

        // 打印合并后的链表
        printList(mergedList);
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