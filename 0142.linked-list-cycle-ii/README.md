# [0142.环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/)

`时间：2023.11.7`

## 题目

给定一个链表的头节点 `head` ，返回链表开始入环的第一个节点。如果链表无环，则返回 `null`。

如果链表中有某个节点，可以通过连续跟踪 `next` 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 `pos` 来表示链表尾连接到链表中的位置（**索引从 0 开始**）。如果 `pos` 是 `-1`，则在该链表中没有环。**注意：**`pos` **不作为参数进行传递**，仅仅是为了标识链表的实际情况。

**不允许修改** 链表。

**示例1：**

```
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
```

**示例2：**

```
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
```

**示例3：**

```
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
```

## 代码

#### 方法一：哈希表法

##### 思路

一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现。

##### 代码

```c++
#include <iostream>
#include <unordered_set>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    // 法一：哈希表法
    ListNode *detectCycle(ListNode *head) {
        unordered_set<ListNode *> myset;
        while (head != nullptr) {
            if (myset.count(head)) {
                return head;
            }
            myset.insert(head);
            head = head->next;
        }
        return nullptr;
    }
};
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。

#### 方法二：快慢指针法

##### 思路

本方法需要读者对「Floyd 判圈算法」（又称龟兔赛跑算法）有所了解。

假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。当「乌龟」和「兔子」从链表上的同一个节点开始移动时，如果该链表中没有环，那么「兔子」将一直处于「乌龟」的前方；如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。等到「乌龟」进入环时，由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈。

我们可以根据上述思路来解决本题。具体地，我们定义两个指针，一快一慢。慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 `head`，而快指针在位置 `head.next`。这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。否则快指针将到达链表尾部，该链表不为环形链表。

##### 代码

```c++
#include <iostream>
#include <unordered_set>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    // 法二：快慢指针
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast = head, *slow = head;
        while (true) {
            if (fast == nullptr || fast->next == nullptr) {
                return nullptr;
            }
            fast = fast->next->next;
            slow = slow->next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            slow = slow->next;
            fast = fast->next;
        }
        return fast;
    }
};
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(1)。
