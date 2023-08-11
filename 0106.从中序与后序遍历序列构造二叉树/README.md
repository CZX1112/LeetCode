# [0106.从中序与后序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

`时间：2023.8.11`

## 题目

给定两个整数数组 `inorder` 和 `postorder` ，其中 `inorder` 是二叉树的中序遍历， `postorder` 是同一棵树的后序遍历，请你构造并返回这颗二叉树。

**示例1：**

```
输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]
```

**示例2：**

```
输入：inorder = [-1], postorder = [-1]
输出：[-1]
```

## 代码

#### 方法：递归法，每次找到当前结点左右两块左右子树递归

##### 思路

对于任意一颗树而言，后续遍历的形式总是

```
[ [左子树的后续遍历结果], [右子树的后续遍历结果], 根节点 ]
```

而中序遍历的形式总是

```
[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
```

根据中序遍历和后续遍历的特性我们进行树的还原过程分析

1. 首先在后序遍历序列中找到根节点(最后一个元素)
2. 根据根节点在中序遍历序列中找到根节点的位置
3. 根据根节点的位置将中序遍历序列分为左子树和右子树
4. 根据根节点的位置确定左子树和右子树在中序数组和后续数组中的左右边界位置
5. 递归构造左子树和右子树
6. 返回根节点结束

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int insize = inorder.length, postsize = postorder.length;
        if (insize != postsize || insize == 0) {
            return null;
        }
        return helper(inorder, 0, insize - 1, postorder, 0, postsize - 1);
    }

    public TreeNode helper(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        TreeNode root = new TreeNode(postorder[r2]);
        if (l2 == r2) {
            return root;
        }
        // 确定分割点位置
        int divide;
        for (divide = l1; divide <= r1; divide++) {
            if (inorder[divide] == postorder[r2]) {
                break;
            }
        }
        // 目标值左侧有值，存在左子树
        if (divide > l1) {
            root.left = helper(inorder, l1, divide - 1, postorder, l2, divide + l2 - l1- 1);
        }
        // 第一个值就是目标值，不存在左子树
        else {
            root.left = null;
        }
        // 目标值右侧有值，存在右子树
        if (divide < r1) {
            root.right = helper(inorder, divide + 1, r1, postorder, divide + l2 - l1, r2 - 1);
        }
        // 最后一个值是目标值，不存在右子树
        else {
            root.right = null;
        }
        return root;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n^2)。其中 n 为二叉树节点的个数。每次递归需要循环找root结点。
- 空间复杂度：O(n)。其中 n 为二叉树节点的个数。