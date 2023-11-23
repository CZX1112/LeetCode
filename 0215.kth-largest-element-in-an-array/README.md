# [0215.数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)

`时间：2023.11.23`

## 题目

给定整数数组 `nums` 和整数 `k`，请返回数组中第 `k` 个最大的元素。

请注意，你需要找的是数组排序后的第 `k` 个最大的元素，而不是第 `k` 个不同的元素。

你必须设计并实现时间复杂度为 `O(n)` 的算法解决此问题。

**示例1：**

```
输入: [3,2,1,5,6,4], k = 2
输出: 5
```

**示例2：**

```
输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4
```

## 代码

#### 方法一：最大堆优先队列

##### 思路

直接用C++的priority_queue，能动态维护最大堆。

##### 代码

```c++
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    // 法一：最大堆优先队列
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> myqueue;
        for (unsigned int i = 0; i < nums.size(); i++) {
            myqueue.push(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            myqueue.pop();
        }
        return myqueue.top();
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
```

##### 复杂度分析

- 时间复杂度：O(NlogK)，遍历数据 O(N)，堆内元素调整 O(log⁡K)。
- 空间复杂度：O(N)。

#### 方法二：部分快排

##### 思路

总体采用快速排序思路，每次执行一半元素的排序。

##### 代码

```c++
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
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
```

##### 复杂度分析

- 时间复杂度：O(N)。部分快排耗时O(N)。
- 空间复杂度：O(log⁡n)。递归使用栈空间的空间代价的期望为 O(log⁡n)。