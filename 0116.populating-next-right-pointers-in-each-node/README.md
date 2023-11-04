# [0116.填充每个节点的下一个右侧节点指针](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/)

`时间：2023.11.4`

## 题目

给定一个 **完美二叉树** ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

```c++
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 `NULL`。

初始状态下，所有 next 指针都被设置为 `NULL`。

**进阶**：

- 你只能使用常量级额外空间。
- 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

**示例1：**

![1](pictures/116_sample.png)

```
输入：root = [1,2,3,4,5,6,7]
输出：[1,#,2,3,#,4,5,6,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
```

**示例2：**

```
输入：root = []
输出：[]
```

## 代码

#### 方法一：层次遍历

##### 思路

详见[[116. 填充每个节点的下一个右侧节点指针 - 力扣（LeetCode）](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solutions/446938/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/))解析

1. 题目本身希望我们将二叉树的每一层节点都连接起来形成一个链表。因此直观的做法我们可以对二叉树进行层次遍历，在层次遍历的过程中将我们将二叉树每一层的节点拿出来遍历并连接。
2. 层次遍历基于广度优先搜索，它与广度优先搜索的不同之处在于，广度优先搜索每次只会取出一个节点来拓展，而层次遍历会每次将队列中的所有元素都拿出来拓展，这样能保证每次从队列中拿出来遍历的元素都是属于同一层的，因此我们可以在遍历的过程中修改每个节点的 next 指针，同时拓展下一层的新队列。

##### 代码

```c++
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
    Node* connect(Node* root) {
        if (root == nullptr) {
            return root;
        }
        queue<Node*> myqueue;
        // 初始化，头节点入队列
        myqueue.push(root);
        // while循环迭代层数
        while (!myqueue.empty()) {
            // 队列大小
            int size = myqueue.size();
            for (int i = 0; i < size; i++) {
                Node* node = myqueue.front();
                myqueue.pop();
                // 连接
                if (i < size - 1) {
                    node->next = myqueue.front();
                }
                // 拓展下一层结点
                if (node->left != nullptr) {
                    myqueue.push(node->left);
                }
                if (node->right != nullptr) {
                    myqueue.push(node->right);
                }
            }
        }
        // 返回根节点
        return root;
    }
};
```

##### 复杂度分析

- 时间复杂度：O(n)，每个节点会被访问一次且只会被访问一次，即从队列中弹出，并建立 next 指针。

- 空间复杂度：O(n)，这是一棵完美二叉树，它的最后一个层级包含 N/2 个节点。广度优先遍历的复杂度取决于一个层级上的最大元素数量。这种情况下空间复杂度为 O(N)。

#### 方法二：使用已建立的 next 指针

##### 思路

详见[[116. 填充每个节点的下一个右侧节点指针 - 力扣（LeetCode）](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solutions/446938/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/))解析

1. 从根节点开始，由于第 0 层只有一个节点，所以不需要连接，直接为第 1 层节点建立 next 指针即可。该算法中需要注意的一点是，当我们为第 N 层节点建立 next 指针时，处于第 N−1 层。当第 N 层节点的 next 指针全部建立完成后，移至第 N 层，建立第 N+1 层节点的 next 指针。
2. 遍历某一层的节点时，这层节点的 next 指针已经建立。因此我们只需要知道这一层的最左节点，就可以按照链表方式遍历，不需要使用队列。

##### 代码

```c++
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
    // 法二：使用已建立的 next\text{next}next 指针
    Node* connect(Node* root) {
        if (root == nullptr) {
            return root;
        }
        // 从根节点开始
        Node* leftmost = root;

        while (leftmost->left != nullptr) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node* head = leftmost;
            while (head != nullptr) {
                // 连接1
                head->left->next = head->right;
                // 连接2
                if (head->next != nullptr) {
                    head->right->next = head->next->left;
                }
                // 指针向后移动
                head = head->next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost->left;
        }
        return root;
    }
};
```

##### 复杂度分析

- 时间复杂度：O(N)，每个节点只访问一次。
- 空间复杂度：O(1)，不需要存储额外的节点。