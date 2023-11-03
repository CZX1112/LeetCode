#include <iostream>
#include <unordered_map>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    // 法一：双指针
    // ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    //     if (headA == nullptr || headB == nullptr) {
    //         return nullptr;
    //     }
    //     ListNode *pA = headA, *pB = headB;
    //     while (pA != pB) {
    //         pA = pA == nullptr ? headB : pA->next;
    //         pB = pB == nullptr ? headA : pB->next;
    //     }
    //     return pA;
    // }

    // 法二：哈希表法
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        unordered_map<ListNode *, int> myMap;
        ListNode *temp = headA;
        while (temp != nullptr) {
            myMap[temp]++;
            temp = temp->next;
        }
        temp = headB;
        while (temp != nullptr) {
            if (myMap[temp] > 0) {
                return temp;
            }
            temp = temp->next;
        }
        return nullptr;
    }
};

int main() {
    // Create the intersected linked lists
    ListNode *listA = new ListNode(4);
    listA->next = new ListNode(1);
    listA->next->next = new ListNode(8);
    listA->next->next->next = new ListNode(4);
    listA->next->next->next->next = new ListNode(5);

    ListNode *listB = new ListNode(5);
    listB->next = new ListNode(6);
    listB->next->next = new ListNode(1);
    // Make them intersect at node with value 8
    listB->next->next->next = listA->next->next;

    Solution solution;
    ListNode *intersectionNode = solution.getIntersectionNode(listA, listB);

    if (intersectionNode != nullptr) {
        cout << "Intersected at '" << intersectionNode->val << "'" << endl;
    } else {
        cout << "No intersection found." << endl;
    }

    // Free memory by deleting the linked lists
    delete listA;
    delete listB;

    system("pause");

    return 0;
}