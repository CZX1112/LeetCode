# [83.最小覆盖子串](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/)

`时间：2023.8.1`

## 题目

给定一个已排序的链表的头 `head` ， 删除所有重复的元素，使每个元素只出现一次 。返回 **已排序的链表** 。

**示例1：**

```
输入：head = [1,1,2]
输出：[1,2]
```

**示例2：**

```
输入：head = [1,1,2,3,3]
输出：[1,2,3]
```

## 代码

#### 方法：一次遍历

##### 思路

由于给定的链表是排好序的，因此**重复的元素在链表中出现的位置是连续的**，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。

具体地，我们从指针 `cur` 指向链表的头节点，随后开始对链表进行遍历。如果当前 `cur` 与 `cur.next` 对应的元素相同，那么我们就将 `cur.next` 从链表中移除；否则说明链表中已经不存在其它与 `cur` 对应的元素相同的节点，因此可以将 `cur` 指向 `cur.next`。

当遍历完整个链表之后，我们返回链表的头节点即可。

**细节**：

当我们遍历到链表的最后一个节点时，`cur.next` 为空节点，如果不加以判断，访问 `cur.next` 对应的元素会产生运行错误。因此我们只需要遍历到链表的最后一个节点，而不需要遍历完整个链表。

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
```

##### 复杂度分析

- 时间复杂度：O(n)。其中n是链表的长度。
- 空间复杂度：O(1)。