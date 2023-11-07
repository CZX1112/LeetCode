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
    // ListNode *detectCycle(ListNode *head) {
    //     unordered_set<ListNode *> myset;
    //     while (head != nullptr) {
    //         if (myset.count(head)) {
    //             return head;
    //         }
    //         myset.insert(head);
    //         head = head->next;
    //     }
    //     return nullptr;
    // }

    // 法二：快慢指针
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast = head, *slow = head;
        while (true) {
            if (fast == nullptr || fast->next == nullptr) {
                return nullptr;
            }
            fast = fast->next->next;
            slow = slow->next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            slow = slow->next;
            fast = fast->next;
        }
        return fast;
    }
};