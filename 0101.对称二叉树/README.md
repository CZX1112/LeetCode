# [0101.对称二叉树](https://leetcode.cn/problems/symmetric-tree/)

`时间：2023.8.7`

## 题目

给你一个二叉树的根节点 `root` ， 检查它是否轴对称。

**示例1：**

```
输入：root = [1,2,2,3,4,4,3]
输出：true
```

**示例2：**

```
输入：root = [1,2,2,null,3,null,3]
输出：false
```

## 代码

#### 方法：递归法

##### 思路

如果一个树的左子树与右子树镜像对称，那么这个树是对称的。

因此，该问题可以转化为：两个树在什么情况下互为镜像？

如果同时满足下面的条件，两个树互为镜像：

- 它们的两个根结点具有相同的值
- 每个树的右子树都与另一个树的左子树镜像对称

我们可以实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，`p` 指针和 `q` 指针一开始都指向这棵树的根，随后 `p` 右移时，`q` 左移，`p` 左移时，`q` 右移。每次检查当前 `p` 和 `q` 节点的值是否相等，如果相等再判断左右子树是否对称。

##### 代码

```java
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。