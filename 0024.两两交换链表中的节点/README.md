# [24.两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/)

`时间：2023.7.5`

## 题目

给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

**示例1：**

```
输入：head = [1,2,3,4]
输出：[2,1,4,3]
```

**示例2：**

```
输入：head = []
输出：[]
```

**示例3：**

```
输入：head = [1]
输出：[1]
```

## 代码

#### 方法：递归

##### 思路

可以通过递归的方式实现两两交换链表中的节点。

递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。

如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，原始链表的第二个节点变成新的链表的头节点。链表中的其余节点的两两交换可以递归地实现。在对链表中的其余节点递归地两两交换之后，更新节点之间的指针关系，即可完成整个链表的两两交换。

用 `head` 表示原始链表的头节点，新的链表的第二个节点，用 `newHead` 表示新的链表的头节点，原始链表的第二个节点，则原始链表中的其余节点的头节点是 `newHead.next`。令 `head.next = swapPairs(newHead.next)`，表示将其余节点进行两两交换，交换后的新的头节点为 `head` 的下一个节点。然后令 `newHead.next = head`，即完成了所有节点的交换。最后返回新的链表的头节点 `newHead`。

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
```

##### 复杂度分析

- 时间复杂度：O(n)，其中n是链表的节点数量。需要对每个节点进行更新指针的操作。
- 空间复杂度：O(n)。其中n是链表的节点数量。空间复杂度主要取决于递归调用的栈空间。