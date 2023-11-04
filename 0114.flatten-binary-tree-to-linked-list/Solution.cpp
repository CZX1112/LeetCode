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
    // void flatten(TreeNode* root) {
    //     vector<TreeNode*> node;
    //     preorderTraversal(root, node);
    //     int length = node.size();
    //     for (int i = 1; i < length; i++) {
    //         TreeNode *prev = node[i - 1], *cur = node[i];
    //         prev->left = nullptr;
    //         prev->right = cur;
    //     }
    // }

    // void preorderTraversal(TreeNode* root, vector<TreeNode*> &node) {
    //     if (root != NULL) {
    //         node.push_back(root);
    //         preorderTraversal(root->left, node);
    //         preorderTraversal(root->right, node);
    //     }
    // }

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