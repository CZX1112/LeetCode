# [0092.反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/)

`时间：2023.8.6`

## 题目

给你单链表的头指针 `head` 和两个整数 `left` 和 `right` ，其中 `left <= right` 。请你反转从位置 `left` 到位置 `right` 的链表节点，返回 **反转后的链表** 。

**示例1：**

```
输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
```

**示例2：**

```
输入：head = [5], left = 1, right = 1
输出：[5]
```

## 代码

#### 方法：多指针法，头插法，类似反转链表

##### 思路

详见：https://leetcode.cn/problems/reverse-linked-list-ii/solutions/634701/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/

画个图，类似反转链表，三个指针即可实现：pre、cur、next。

##### 代码

```java
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
    // 多指针法，头插法
    // 类似反转链表就行
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 创建测试链表 [1, 2, 3, 4, 5]
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        int left = 2;
        int right = 4;

        // 打印原始链表
        System.out.print("原始链表: ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();

        // 调用 reverseBetween 方法
        Solution solution = new Solution();
        ListNode result = solution.reverseBetween(head, left, right);

        // 打印反转后的链表
        System.out.print("反转后的链表: ");
        current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。其中n是链表总节点数。最多只遍历了链表一次，就完成了反转。
- 空间复杂度：O(1)。只使用到常数个变量。