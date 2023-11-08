# [0144.二叉树的后序遍历](https://leetcode.cn/problems/binary-tree-postorder-traversal/)

`时间：2023.11.8`

## 题目

给你一棵二叉树的根节点 `root` ，返回其节点值的 **后序遍历** 。

**示例1：**

```
输入：root = [1,null,2,3]
输出：[3,2,1]
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

直接递归。

##### 代码

```c++
#include <iostream>
#include <vector>.

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        postOrder(root, result);
        return result;
    }
    void postOrder(TreeNode* root, vector<int>& result) {
        if (root == nullptr) {
            return;
        }
        postOrder(root->left, result);
        postOrder(root->right, result);
        result.push_back(root->val);
    }
};
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。
