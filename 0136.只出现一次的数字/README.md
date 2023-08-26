# [0136.只出现一次的数字](https://leetcode.cn/problems/single-number/)

`时间：2023.8.26`

## 题目

给你一个 **非空** 整数数组 `nums` ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。

**示例1：**

```
输入：nums = [2,2,1]
输出：1
```

**示例2：**

```
输入：nums = [4,1,2,1,2]
输出：4
```

**示例3：**

```
输入：nums = [1]
输出：1
```

## 代码

#### 方法一：哈希表法

##### 思路

利用哈希表依次记录每个元素出现的次数，最后判断哪个元素只出现了一次返回即可。

##### 代码

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    // 法一：哈希表法
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            }
            else {
                hashMap.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return 0;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。

#### 方法二：位运算异或法

##### 思路

用0与所有元素异或。如果出现两次的元素分别异或后为0，最后的值即为单独的那个值，返回最终异或结果即可。

##### 代码

```java
class Solution {
    //法二：位运算异或法
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4,1,2,1,2};
        int result = sol.singleNumber(nums);
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(1)。