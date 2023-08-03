# [86.分隔链表](https://leetcode.cn/problems/partition-list/)

`时间：2023.8.3`

## 题目

给你一个链表的头节点 `head` 和一个特定值 `x` ，请你对链表进行分隔，使得所有 **小于** x 的节点都出现在 **大于或等于** `x` 的节点之前。

你应当 **保留** 两个分区中每个节点的初始相对位置。

**示例1：**

```
输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]
```

**示例2：**

```
输入：head = [2,1], x = 2
输出：[1,2]
```

## 代码

#### 方法：模拟，双链表指针，large + small

##### 思路

直观来说我们只需维护两个链表 `small` 和 `large` 即可，`small` 链表按顺序存储所有小于 `x` 的节点，`large` 链表按顺序存储所有大于等于 `x` 的节点。遍历完原链表后，我们只要将 `small` 链表尾节点指向 `large` 链表的头节点即能完成对链表的分隔。

为了实现上述思路，我们设 `smallHead` 和 `largeHead` 分别为两个链表的哑节点，即它们的 `next` 指针指向链表的头节点，这样做的目的是为了更方便地处理头节点为空的边界条件。同时设 `small` 和 `large` 节点指向当前链表的末尾节点。开始时 `smallHead=small,largeHead=large` 随后，从前往后遍历链表，判断当前链表的节点值是否小于 `x`，如果小于就将 `small` 的 `next` 指针指向该节点，否则将 `large` 的 `next` 指针指向该节点。

遍历结束后，我们将 `large` 的 `next` 指针置空，这是因为当前节点复用的是原链表的节点，而其 `next` 指针可能指向一个小于 `x` 的节点，我们需要切断这个引用。同时将 `small` 的 `next` 指针指向 `largeHead` 的 `next` 指针指向的节点，即真正意义上的 `large` 链表的头节点。最后返回 `smallHead` 的 `next` 指针即为我们要求的答案。

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
    // 双链表指针，large + small
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }
            else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        small.next = largeHead.next;
        large.next = null;
        return smallHead.next;
    }

    public static void main(String[] args) {
        // Create the input linked list: head = [1,4,3,2,5,2]
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;
        // Call the partition function
        Solution solution = new Solution();
        ListNode result = solution.partition(head, x);
        // Print the output linked list: [1,2,2,4,3,5]
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。其中n是链表的长度，我们对该链表进行了一次遍历
- 空间复杂度：O(1)。