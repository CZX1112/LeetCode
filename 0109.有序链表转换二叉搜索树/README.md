# [0109.有序链表转换二叉搜索树](https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/)

`时间：2023.8.11`

## 题目

给定一个单链表的头节点 `head` ，其中的元素 **按升序排序** ，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。

**示例1：**

```
输入: head = [-10,-3,0,5,9]
输出: [0,-3,9,-10,null,5]
解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
```

**示例2：**

```
输入: head = []
输出: []
```

## 代码

#### 方法一：先转为数组，中序遍历，总是选择中间位置左边的数字作为根节点

##### 思路

类似0108，先将链表转换为数组。

要使生成的二叉搜索树平衡，可采取每次使用中间位置数字作为根节点。中序遍历，总是选择中间位置左边的数字作为根节点，则根节点的下标为 `mid=(left+right)/2`，此处的除法为整数除法。

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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        return helper(array, 0, array.size());
    }

    public TreeNode helper(List<Integer> array, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(array.get(mid));
        root.left = helper(array, left, mid - 1);
        root.right = helper(array, mid + 1, right);
        return root;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。其中 n 是链表的长度。每个数字只访问两次。
- 空间复杂度：O(n)。需要用一个数组存储链表的值。

#### 方法二：中序遍历，直接建树，不需要存储

##### 思路

强烈推荐！！！：[109. 有序链表转换二叉搜索树 - 力扣（LeetCode）](https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/solutions/378582/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-1-3/)

[109. 有序链表转换二叉搜索树 - 力扣（LeetCode）](https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/solutions/378753/shou-hua-tu-jie-san-chong-jie-fa-jie-zhu-shu-zu-ku/)

- 其实直接获取链表头结点：O(1)，不如直接构建它吧！它对应 BST 最左子树的根节点。

- 于是我们先构建左子树，再构建根节点，再构建右子树。——遵循中序遍历。

- 其实，BST 的中序遍历，打印的节点值正是这个有序链表的节点值顺序。

- ，维护指针 ptr，从头结点开始，用 ptr.val 构建节点，构建一个，指针后移一位。

- 求出链表结点总个数，用于每次二分求出链表的中点。

- 为什么要这么做，因为我们构建的节点值是：从小到大，我们希望在递归中处理节点的顺序和链表结点顺序一一对应

- 用二分后的左链，递归构建左子树，然后用 ptr.val 创建节点，接上创建好的左子树，再用右链构建右子树，再接上。

- 递归中会不断进行二分，直到无法划分就返回 null，即来到递归树的底部

- ptr.val 创建完结点后，ptr 指针就后移，锁定出下一个要构建的节点值……

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
```

##### 复杂度分析

- 时间复杂度：O(n)。其中 n 是链表的长度。
- 空间复杂度：O(logn)。空间复杂度相比转为数组降低了。