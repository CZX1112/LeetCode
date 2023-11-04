#include <iostream>
#include <queue>

using namespace std;

// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};

class Solution {
public:
    // 法一：队列层次遍历
    // Node* connect(Node* root) {
    //     if (root == nullptr) {
    //         return root;
    //     }
    //     queue<Node*> myqueue;
    //     // 初始化，头节点入队列
    //     myqueue.push(root);
    //     // while循环迭代层数
    //     while (!myqueue.empty()) {
    //         // 队列大小
    //         int size = myqueue.size();
    //         for (int i = 0; i < size; i++) {
    //             Node* node = myqueue.front();
    //             myqueue.pop();
    //             // 连接
    //             if (i < size - 1) {
    //                 node->next = myqueue.front();
    //             }
    //             // 拓展下一层结点
    //             if (node->left != nullptr) {
    //                 myqueue.push(node->left);
    //             }
    //             if (node->right != nullptr) {
    //                 myqueue.push(node->right);
    //             }
    //         }
    //     }
    //     return root;
    // }

    // 法二：BFS使用已建立的 next 指针
    Node* connect(Node* root) {
        if (root == nullptr) {
            return root;
        }
        Node* cur = root;
        while (cur != nullptr) {
            Node* head = new Node(-1), *tail = head;
            for (Node* nownode = cur; nownode != nullptr; nownode = nownode->next) {
                if (nownode->left) {
                    tail->next = nownode->left;
                    tail = tail->next;
                }
                if (nownode->right) {
                    tail->next = nownode->right;
                    tail = tail->next;
                }
            }
            cur = head->next;
        }
        return root;
    }
};