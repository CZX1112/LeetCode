#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    // 法一：最大堆优先队列
    // int findKthLargest(vector<int>& nums, int k) {
    //     priority_queue<int> myqueue;
    //     for (unsigned int i = 0; i < nums.size(); i++) {
    //         myqueue.push(nums[i]);
    //     }
    //     for (int i = 0; i < k - 1; i++) {
    //         myqueue.pop();
    //     }
    //     return myqueue.top();
    // }

    // 法二：部分快排取TOPK
    int findKthLargest(vector<int>& nums, int k) {
        return quickSort(nums, 0, nums.size() - 1, k);
    }

    int partition(vector<int>& nums, int L, int R) {
        int left = L, right = R, pivot = nums[L];
        while (left < right) {
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
            if (left >= right) {
                nums[left] = pivot;
            }
        }
        return left;
    }

    int quickSort(vector<int>& nums, int L, int R, int k) {
        int divide = partition(nums, L, R);
        if (divide == k - 1) {
            return nums[k - 1];
        }
        else if (k - 1 > divide) {
            return quickSort(nums, divide + 1, R, k);
        }
        else {
            return quickSort(nums, L, divide - 1, k);
        }
    }
};

int main() {
    Solution sol;
    vector<int> nums = {3,2,1,5,6,4};
    int k = 2;
    int result = sol.findKthLargest(nums, k);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}