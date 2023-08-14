# [0113.路径总和 II](https://leetcode.cn/problems/path-sum-ii/)

`时间：2023.8.14`

## 题目

给你二叉树的根节点 `root` 和一个整数目标和 `targetSum` ，找出所有 **从根节点到叶子节点** 路径总和等于给定目标和的路径。

**叶子节点** 是指没有子节点的节点。

**示例1：**

```
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
```

**示例2：**

```
输入：root = [1,2,3], targetSum = 5
输出：[]
```

**示例3：**

```
输入：root = [1,2], targetSum = 0
输出：[]
```

## 代码

#### 方法：深度优先搜索 DFS递归法

##### 思路

我们可以采用深度优先搜索的方式，枚举每一条从根节点到叶子节点的路径。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。

##### 代码

```java
import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(result, temp, root, targetSum);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(temp));
        }
        helper(result, temp, root.left, targetSum);
        helper(result, temp, root.right, targetSum);
        temp.remove(temp.size() - 1);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(N^2)。
- 空间复杂度：O(N)。N为树的节点数。取决于栈的开销。