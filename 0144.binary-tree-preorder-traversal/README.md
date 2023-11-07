# [0144.二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/)

`时间：2023.11.7`

## 题目

给你二叉树的根节点 `root` ，返回它节点值的 **前序** 遍历。

**示例1：**

```
输入：root = [1,null,2,3]
输出：[1,2,3]
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

**示例4：**

```
输入：root = [1,2]
输出：[1,2]
```

**示例5：**

```
输入：root = [1,null,2]
输出：[1,2]
```

## 代码

#### 方法：递归法

##### 思路

直接递归。

##### 代码

```c++
#include <iostream>
#include <vector>

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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        preOrder(root, result);
        return result;
    }
    void preOrder(TreeNode* root, vector<int>& result) {
        if (root == nullptr) {
            return;
        }
        result.push_back(root->val);
        preOrder(root->left, result);
        preOrder(root->right, result);
    }
};
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。
