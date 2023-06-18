# [1.两数相加](https://leetcode.cn/problems/add-two-numbers/)

`时间：2023.6.18`

## 题目

给你两个 **非空** 的链表，表示两个非负的整数。它们每位数字都是按照 **逆序** 的方式存储的，并且每个节点只能存储 **一位** 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

**示例1：**

```
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
```

**示例2：**

```
输入：l1 = [0], l2 = [0]
输出：[0]
```

**示例3：**

```
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
```

## 代码

#### 方法：模拟

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