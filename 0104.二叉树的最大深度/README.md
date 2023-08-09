# [0104.二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/)

`时间：2023.8.9`

## 题目

给定一个二叉树 `root` ，返回其最大深度。

二叉树的 **最大深度** 是指从根节点到最远叶子节点的最长路径上的节点数。

**示例1：**

```
输入：root = [3,9,20,null,null,15,7]
输出：3
```

**示例2：**

```
输入：root = [1,null,2]
输出：2
```

## 代码

#### 方法一：深度优先搜索 DFS递归

##### 思路

如果我们知道了左子树和右子树的最大深度 `l` 和 `r`，那么该二叉树的最大深度即为：

`max(l, r) + 1`

而左子树和右子树的最大深度又可以以同样的方式进行计算。因此我们可以用「深度优先搜索」的方法来计算二叉树的最大深度。具体而言，在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，然后在 `O(1)` 时间内计算出当前二叉树的最大深度。递归在访问到空节点时退出。

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
    // 法一：深度优先搜索，递归dfs
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。其中 `n` 为二叉树节点的个数。每个节点在递归中只被遍历一次。
- 空间复杂度：O(height)。其中 `height` 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。

#### 方法二：广度优先搜索 BFS队列

##### 思路

我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展，最后我们用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为 ans。

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
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    // 法二：广度优先搜索，用队列
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> myqueue = new ArrayDeque<>();
        myqueue.offer(root);
        int depth = 0;
        while (!myqueue.isEmpty()) {
            depth++;
            int size = myqueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode nownode = myqueue.poll();
                if (nownode.left != null) {
                    myqueue.offer(nownode.left);
                }
                if (nownode.right != null) {
                    myqueue.offer(nownode.right);
                }
            }
        }
        return depth;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
- 空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到 O(n)。