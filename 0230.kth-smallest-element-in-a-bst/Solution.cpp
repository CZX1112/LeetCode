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
    // int kthSmallest(TreeNode* root, int k) {
    //     vector<int> result;
    //     inOrder(root, result);
    //     return result[k - 1];
    // }
    // void inOrder(TreeNode* root, vector<int>& result) {
    //     if (root == nullptr) {
    //         return;
    //     }
    //     inOrder(root->left, result);
    //     result.push_back(root->val);
    //     inOrder(root->right, result);
    // }

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