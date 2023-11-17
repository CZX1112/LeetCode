# [0230.岛屿数量](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/)

`时间：2023.11.17`

## 题目

给定一个二叉搜索树的根节点 `root` ，和一个整数 `k` ，请你设计一个算法查找其中第 `k` 个最小元素（从 1 开始计数）。

**示例1：**

```
输入：root = [3,1,4,null,2], k = 1
输出：1
```

**示例2：**

```
输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3
```

## 代码

#### 方法一：中序遍历

##### 思路

直接中序遍历把结果用数组存起来最后取result[k - 1]就行。

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
    // 法一：中序遍历
    int kthSmallest(TreeNode* root, int k) {
        vector<int> result;
        inOrder(root, result);
        return result[k - 1];
    }
    void inOrder(TreeNode* root, vector<int>& result) {
        if (root == nullptr) {
            return;
        }
        inOrder(root->left, result);
        result.push_back(root->val);
        inOrder(root->right, result);
    }
private:
    int result, k;
};
```

##### 复杂度分析

- 时间复杂度：O(H + k)，H是树的高度。
- 空间复杂度：O(H)。栈中最多需要存储 H 个元素。

#### 方法二：阉割版中序遍历

##### 思路

为求第 k 个节点，需要实现以下三项工作：

- 递归遍历时计数，统计当前节点的序号。
- 递归到第 k 个节点时，应记录结果 res 。
- 记录结果后，后续的遍历即失去意义，应提前返回。

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
    // 法二：阉割版中序遍历
    int kthSmallest(TreeNode* root, int k) {
        this->k = k;
        inOrder(root);
        return result;
    }
    void inOrder(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        inOrder(root->left);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            result = root->val;
        }
        inOrder(root->right);
    }
private:
    int result, k;
};
```

##### 复杂度分析

- 时间复杂度：O(N)。
- 空间复杂度：O(N)。
