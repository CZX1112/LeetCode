# [94.二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/)

`时间：2023.8.2`

## 题目

给定一个二叉树的根节点 `root` ，返回 它的 **中序** 遍历 。

**示例1：**

```
输入：root = [1,null,2,3]
输出：[1,3,2]
```

**示例2：**

```
输入：root = []
输出：[]
```

**示例3：**

```
输入：root = [1]
输出：[1]
```

## 代码

#### 方法：递归法

##### 思路

按照访问左子树——根节点——右子树的方式遍历这棵树，而在访问左子树或者右子树的时候我们按照同样的方式遍历，直到遍历完整棵树。因此整个遍历过程天然具有递归的性质，我们可以直接用递归函数来模拟这一过程。

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
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args) {
        // Create the tree: [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        // Create an instance of Solution class
        Solution solution = new Solution();
        // Call the inorderTraversal method and get the result
        List<Integer> result = solution.inorderTraversal(root);
        // Print the output
        System.out.println(result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。