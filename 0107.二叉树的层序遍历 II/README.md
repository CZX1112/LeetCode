# [0107.二叉树的最大深度](https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/)

`时间：2023.8.10`

## 题目

给你二叉树的根节点 `root` ，返回其节点值 **自底向上的层序遍历** 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

**示例1：**

```
输入：root = [3,9,20,null,null,15,7]
输出：[[15,7],[9,20],[3]]
```

**示例2：**

```
输入：root = [1]
输出：[[1]]
```

**示例3：**

```
输入：root = []
输出：[]
```


## 代码

#### 方法：FS广度优先搜索 用队列

##### 思路

类似于0102.二叉树的层序遍历，队列层序遍历，先得到一个二维数组，再翻转这个二维数组即可。

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
import java.util.Collections;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> myqueue = new ArrayDeque<>();
        myqueue.offer(root);
        while (!myqueue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = myqueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode nownode = myqueue.poll();
                temp.add(nownode.val);
                if (nownode.left != null) {
                    myqueue.add(nownode.left);
                }
                if (nownode.right != null) {
                    myqueue.add(nownode.right);
                }
            }
            result.add(temp);
        }
        Collections.reverse(result);
        return result;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。每个点进队出队各一次，故渐进时间复杂度为O(n)。
- 空间复杂度：O(n)。队列中元素的个数不超过n个，故渐进空间复杂度为O(n)。