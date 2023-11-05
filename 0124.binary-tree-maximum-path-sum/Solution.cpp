#include <iostream>
#include <climits>
#include <math.h>

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
private:
    int maxSum = INT_MIN;
public:
    int maxPathSum(TreeNode* root) {
        helper(root);
        return maxSum;
    }

    int helper(TreeNode* node) {
        if (node == nullptr) {
            return 0;
        }
        // 计算左边分支最大值，左边分支如果为负数还不如不选择
        int leftGain = max(helper(node->left), 0);
        // 计算右边分支最大值，右边分支如果为负数还不如不选择
        int rightGain = max(helper(node->right), 0);

        // left->root->right 作为路径与已经计算过历史最大值做比较
        int priceNewpath = node->val + leftGain + rightGain;
        maxSum = max(maxSum, priceNewpath);
        // 返回经过root的单边最大分支给当前root的父节点计算使用
        return node->val + max(leftGain, rightGain);
    }
};