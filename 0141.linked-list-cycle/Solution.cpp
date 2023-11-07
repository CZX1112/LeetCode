#include <iostream>
#include <unordered_set>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    // 法一：哈希表法
    // bool hasCycle(ListNode *head) {
    //     unordered_set<ListNode*> myset;
    //     while (head != nullptr) {
    //         if (myset.count(head)) {
    //             return true;
    //         }
    //         myset.insert(head);
    //         head = head->next;
    //     }
    //     return false;
    // }

    // 法二：快慢指针
    bool hasCycle(ListNode *head) {
        if (head == nullptr || head->next == nullptr) {
            return false;
        }
        ListNode *slow = head, *fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
};