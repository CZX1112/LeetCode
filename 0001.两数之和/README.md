# [1.两数之和](https://leetcode.cn/problems/two-sum/)

## 题目

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出**和**为目标值 target 的那**两个**整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

**示例1：**

```
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

**示例2：**

```
输入：nums = [3,2,4], target = 6
输出：[1,2]
```

**示例3：**

```
输入：nums = [3,3], target = 6
输出：[0,1]
```

## 代码

#### 方法一：暴力枚举

##### 思路

枚举数组中的每一个数 `x`，寻找数组中是否存在 `target - x`。

##### 代码

```java
class Solution {
    // 法一：暴力枚举
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] number = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    number[0] = i;
                    number[1] = j;
                    return number;
                }
            }
        }
        return number;
    }
}
```

##### 复杂度分析

- 时间复杂度：*O*(n^2)，其中是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
- 空间复杂度：O(1)。

#### 方法二：哈希表

##### 思路

使用哈希表，可以将寻找 target - x 的时间复杂度降低到从O(N)降低到O(1)。

这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。

##### 代码

```java
import java.util.HashMap;

class Solution {
    // 法二：哈希表法
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
```

##### 复杂度分析

- 时间复杂度：*O*(n)，对于每一个元素 `x`，我们可以O(1)地寻找 `target - x`。
- 空间复杂度：O(N)。其中N是数组中的元素数量。主要为哈希表的开销。