# [0114.二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/)

`时间：2023.11.4`

## 题目

给你二叉树的根结点 `root` ，请你将它展开为一个单链表：

- 展开后的单链表应该同样使用 `TreeNode` ，其中 `right` 子指针指向链表中下一个结点，而左子指针始终为 `null` 。

- 展开后的单链表应该与二叉树 **先序遍历** 顺序相同。

**进阶**：你可以使用原地算法（`O(1)` 额外空间）展开这棵树吗？

**示例1：**

![1](pictures/flaten.jpg)

```
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
```

**示例2：**

```
输入：root = []
输出：[]
```

**示例3：**

```
输入：root = [0]
输出：[0]
```

**进阶**：你能否设计一个时间复杂度 `O(m + n)` 、仅用 `O(1)` 内存的解决方案？

## 代码

#### 方法一：前序遍历，数组存储

##### 思路

将二叉树展开为单链表之后，单链表中的节点顺序即为二叉树的前序遍历访问各节点的顺序。因此，可以对二叉树进行前序遍历，获得各节点被访问到的顺序。由于将二叉树展开为链表之后会破坏二叉树的结构，因此在前序遍历结束之后更新每个节点的左右子节点的信息，将二叉树展开为单链表。

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
    // 法一：前序遍历，数组存储
    void flatten(TreeNode* root) {
        vector<TreeNode*> node;
        preorderTraversal(root, node);
        int length = node.size();
        for (int i = 1; i < length; i++) {
            TreeNode *prev = node[i - 1], *cur = node[i];
            prev->left = nullptr;
            prev->right = cur;
        }
    }

    void preorderTraversal(TreeNode* root, vector<TreeNode*> &node) {
        if (root != NULL) {
            node.push_back(root);
            preorderTraversal(root->left, node);
            preorderTraversal(root->right, node);
        }
    }
};

// 打印展开后的链表
void printFlattenedTree(TreeNode* root) {
    while (root != nullptr) {
        cout << root->val << " -> ";
        root = root->right;
    }
    cout << "null" << endl;
}

int main() {
    // 创建示例输入二叉树
    cout << "test" << endl;
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(4);
    root->right = new TreeNode(5);
    root->right->right = new TreeNode(6);

    Solution solution;
    solution.flatten(root);

    cout << "Flattened tree: ";
    printFlattenedTree(root);

    system("pause");
    return 0;
}
```

##### 复杂度分析

- 时间复杂度：O(n)，其中 n 是二叉树的节点数。前序遍历的时间复杂度是 O(n)，前序遍历之后，需要对每个节点更新左右子节点的信息，时间复杂度也是 O(n)。

- 空间复杂度：O(n)，其中 n 是二叉树的节点数。空间复杂度取决于栈（递归调用栈或者迭代中显性使用的栈）和存储前序遍历结果的列表的大小，栈内的元素个数不会超过 n，前序遍历列表中的元素个数是 n。

#### 方法二：寻找前驱节点

##### 思路

详见[114. 二叉树展开为链表 - 力扣（LeetCode）](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/356853/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/)示意图

前两种方法都借助前序遍历，前序遍历过程中需要使用栈存储节点。有没有空间复杂度是 O(1) 的做法呢？

注意到前序遍历访问各节点的顺序是根节点、左子树、右子树。如果一个节点的左子节点为空，则该节点不需要进行展开操作。如果一个节点的左子节点不为空，则该节点的左子树中的最后一个节点被访问之后，该节点的右子节点被访问。该节点的左子树中最后一个被访问的节点是左子树中的最右边的节点，也是该节点的前驱节点。因此，问题转化成寻找当前节点的前驱节点。

具体做法是，对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。

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
    // 法二：寻找前驱节点
    void flatten(TreeNode* root) {
        TreeNode *curr = root;
        while (curr != nullptr) {
            if (curr->left != nullptr) {
                TreeNode *next = curr->left;
                TreeNode *pre = next;
                while (pre->right != nullptr) {
                    pre = pre->right;
                }
                pre->right = curr->right;
                curr->left = nullptr;
                curr->right = next;
            }
            curr = curr->right;
        }
    }
};

// 打印展开后的链表
void printFlattenedTree(TreeNode* root) {
    while (root != nullptr) {
        cout << root->val << " -> ";
        root = root->right;
    }
    cout << "null" << endl;
}

int main() {
    // 创建示例输入二叉树
    cout << "test" << endl;
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(4);
    root->right = new TreeNode(5);
    root->right->right = new TreeNode(6);

    Solution solution;
    solution.flatten(root);

    cout << "Flattened tree: ";
    printFlattenedTree(root);

    system("pause");
    return 0;
}
```

##### 复杂度分析

- 时间复杂度：O(n)，其中 n 是二叉树的节点数。展开为单链表的过程中，需要对每个节点访问一次，在寻找前驱节点的过程中，每个节点最多被额外访问一次。
- 空间复杂度：O(1)。