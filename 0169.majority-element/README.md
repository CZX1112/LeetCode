# [0169.多数元素](https://leetcode.cn/problems/majority-element/)

`时间：2023.11.2`

## 题目

给定一个大小为 `n` 的数组 `nums` ，返回其中的多数元素。多数元素是指在数组中出现次数 **大于** `⌊ n/2 ⌋` 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

**示例1：**

```
输入：nums = [3,2,3]
输出：3
```

**示例2：**

```
输入：nums = [2,2,1,1,1,2,2]
输出：2
```

## 代码

#### 方法一：哈希表法

##### 思路

我们使用哈希映射（HashMap）来存储每个元素以及出现的次数。对于哈希映射中的每个键值对，键表示一个元素，值表示该元素出现的次数。

我们用一个循环遍历数组 nums 并将数组中的每个元素加入哈希映射中。在这之后，我们遍历哈希映射中的所有键值对，返回值最大的键。

##### 代码

```c++
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    // 法一：哈希表法
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> myMap;
        int nowNum = nums[0];
        for (unsigned int i = 0; i < nums.size(); i++) {
            myMap[nums[i]]++;
        }
        int length = nums.size() / 2;
        for (int i = 0; i < nums.size(); i++) {
            if (myMap[nums[i]] > length) {
                nowNum = nums[i];
                break;
            }
        }
        return nowNum;
    }
};

int main() {
    Solution solution;
    vector<int> nums = {2,2,1,1,1,2,2};
    int maj = solution.majorityElement(nums);
    cout << "maj: " << maj << endl;
    system("pause");
    return 0;
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。

#### 方法二：Boyer-Moore 投票算法

##### 思路

Boyer-Moore投票算法：如果我们把众数记为 `+1`，把其他数记为 `−1`，将它们全部加起来，显然和大于 `0`，从结果本身我们可以看出众数比其他数多。

##### 代码

```c++
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    // 法二：Boyer-Moore投票算法
    int majorityElement(vector<int>& nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == candidate) {
                count++;
            }
            else {
                count--;
            }
            if (count <= 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }
};

int main() {
    Solution solution;
    vector<int> nums = {2,2,1,1,1,2,2};
    int maj = solution.majorityElement(nums);
    cout << "maj: " << maj << endl;
    system("pause");
    return 0;
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(1)。