# [0217.存在重复元素](https://leetcode.cn/problems/contains-duplicate/)

`时间：2023.11.17`

## 题目

给你一个整数数组 `nums` 。如果任一值在数组中出现 **至少两次** ，返回 `true` ；如果数组中每个元素互不相同，返回 `false` 。

**示例1：**

```
输入：nums = [1,2,3,1]
输出：true
```

**示例2：**

```
输入：nums = [1,2,3,4]
输出：false
```

**示例3：**

```
输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
```

## 代码

#### 方法：哈希表法

##### 思路

对于数组中每个元素，我们将它插入到哈希表中。如果插入一个元素时发现该元素已经存在于哈希表中，则说明存在重复的元素。

##### 代码

```c++
#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> myhashset;
        int length = nums.size();
        for (int i = 0; i < length; i++) {
            if (myhashset.find(nums[i]) != myhashset.end()) {
                return true;
            }
            myhashset.insert(nums[i]);
        }
        return false;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {1,2,3,1};
    bool result = sol.containsDuplicate(nums);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}
```

##### 复杂度分析

- 时间复杂度：O(N)，其中 N 为数组的长度。
- 空间复杂度：O(N)，其中 N 为数组的长度。
