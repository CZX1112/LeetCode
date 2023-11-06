# [0137.只出现一次的数字 II](https://leetcode.cn/problems/single-number-ii/)

`时间：2023.11.6`

## 题目

给你一个整数数组 `nums` ，除某个元素仅出现 **一次** 外，其余每个元素都恰出现 **三次** 。请你找出并返回那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。

**示例1：**

```
输入：nums = [2,2,3,2]
输出：3
```

**示例2：**

```
输入：nums = [0,1,0,1,0,1,99]
输出：99
```

## 代码

#### 方法：哈希表法

##### 思路

我们可以使用哈希映射统计数组中每个元素的出现次数。对于哈希映射中的每个键值对，键表示一个元素，值表示其出现的次数。

在统计完成后，我们遍历哈希映射即可找出只出现一次的元素。

##### 代码

```java
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_map<int, int> mymap;
        for (int i = 0; i < nums.size(); i++) {
            mymap[nums[i]]++;
        }
        int result = nums[0];
        for (auto pair : mymap) {
            if (pair.second == 1) {
                result = pair.first;
                break;
            }
        }
        return result;
    }
};

int main() {
    vector<int> nums = {0,1,0,1,0,1,99};
    Solution sol;
    int result = sol.singleNumber(nums);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。
