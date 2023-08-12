# [0111.二叉树的最小深度](https://leetcode.cn/problems/minimum-depth-of-binary-tree/)

`时间：2023.8.12`

## 题目

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

**说明：**叶子节点是指没有子节点的节点。

**示例1：**

```
输入：root = [3,9,20,null,null,15,7]
输出：2
```

**示例2：**

```
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
```

## 代码

#### 方法一：深度优先搜索DFS

##### 思路

首先可以想到使用深度优先搜索的方法，遍历整棵树，记录最小深度。

对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题。

需要注意当左右子树有一个高度为0的情况特判。

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
    // 法一：深度优先搜索
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 首先需要保证有左右子树，即高度不能为0
        if (leftDepth == 0 || rightDepth == 0) {
            return leftDepth + rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(N)。其中 N 是树的节点数。对每个节点访问一次。
- 空间复杂度：O(H)。其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销。

#### 方法二：广度优先搜索BFS

##### 思路

同样，我们可以想到使用广度优先搜索的方法，遍历整棵树。

当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。

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
    // 法二：广度优先搜索
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> myqueue = new ArrayDeque<>();
        myqueue.offer(root);
        while (!myqueue.isEmpty()) {
            depth++;
            int size = myqueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode nownode = myqueue.poll();
                if (nownode.left == null && nownode.right == null) {
                    return depth;
                }
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

- 时间复杂度：O(N)。其中 N 是树的节点数。对每个节点访问一次。
- 空间复杂度：O(N)。其中 N 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。