# [25.K个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/)

`时间：2023.7.5`

## 题目

给你链表的头节点 `head` ，每 `k` 个节点一组进行翻转，请你返回修改后的链表。

`k` 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 `k` 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

**示例1：**

```
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
```

**示例2：**

```
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
```

## 代码

#### 方法：模拟

##### 思路

1. 链表分区为已翻转部分+待翻转部分+未翻转部分
2. 每次翻转前，要确定翻转链表的范围，这个必须通过 `k` 次循环来确定
3. 需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
4. 初始需要两个变量 `pre` 和 `end`，`pre` 代表待翻转链表的前驱，`end` 代表待翻转链表的末尾
5. 经过 `k` 次循环，`end` 到达末尾，记录待翻转链表的后继 `next = end.next`
6. 翻转链表，然后将三部分链表连接起来，然后重置 `pre` 和 `end` 指针，然后进入下一次循环
7. 特殊情况，当翻转部分长度不足 `k` 时，在定位 `end` 完成后，`end==null`，已经到达末尾，说明题目已完成，直接返回即可

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
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), prev = dummy;
        while (true) {
            // 检查剩余节点是否有k个，不足则返回
            ListNode last = prev;
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null) {
                    return dummy.next;
                }
            }

            // 翻转k个节点
            ListNode curr = prev.next, next;
            for (int i = 0; i < k - 1; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
        }
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)，其中n是链表的长度。
- 空间复杂度：O(1)，我们只需要建立常数个变量。