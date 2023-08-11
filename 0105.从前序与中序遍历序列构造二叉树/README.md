# [0105.从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

`时间：2023.8.11`

## 题目

给定两个整数数组 `preorder` 和 `inorder` ，其中 `preorder` 是二叉树的**先序遍历**， `inorder` 是同一棵树的**中序遍历**，请构造二叉树并返回其根节点。

**示例1：**

```
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
```

**示例2：**

```
输入: preorder = [-1], inorder = [-1]
输出: [-1]
```

## 代码

#### 方法：递归法，每次找到当前结点左右两块左右子树递归

##### 思路

对于任意一颗树而言，前序遍历的形式总是

```
[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
```

即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是

```
[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
```

只要我们在中序遍历中**定位**到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有**左右括号**进行定位。

这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int presize = preorder.length, insize = inorder.length;
        if (presize != insize || presize == 0) {
            return null;
        }
        return helper(preorder, 0, presize - 1, inorder, 0, insize - 1);
    }

    public TreeNode helper(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        TreeNode root = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return root;
        }
        // 确定分割点位置
        int divide;
        for (divide = l2; divide <= r2; divide++) {
            if (inorder[divide] == preorder[l1]) {
                break;
            }
        }
        // 目标值左侧有值，存在左子树
        if (divide > l2) {
            root.left = helper(preorder, l1 + 1, l1 + divide - l2, inorder, l2, divide - 1);
        }
        // 第一个值就是目标值，不存在左子树
        else {
            root.left = null;
        }
        // 目标值右侧有值，存在右子树
        if (divide < r2) {
            root.right = helper(preorder, l1 + divide - l2 + 1, r1, inorder, divide + 1, r2);
        }
        return root;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n^2)。其中 n 为二叉树节点的个数。每次递归需要循环找root结点。
- 空间复杂度：O(n)。其中 n 为二叉树节点的个数。