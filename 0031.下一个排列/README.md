# [31.下一个排列](https://leetcode.cn/problems/next-permutation/)

`时间：2023.7.6`

## 题目

整数数组的一个 **排列** 就是将其所有成员以序列或线性顺序排列。

- 例如，`arr = [1,2,3]` ，以下这些都可以视作 `arr` 的排列：`[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1]` 。

整数数组的 **下一个排列** 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 **下一个排列** 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

- 例如，`arr = [1,2,3]` 的下一个排列是 `[1,3,2]` 。
- 类似地，`arr = [2,3,1]` 的下一个排列是 `[3,1,2]` 。
- 而 `arr = [3,2,1]` 的下一个排列是 `[1,2,3]` ，因为 `[3,2,1]` 不存在一个字典序更大的排列。

给你一个整数数组 `nums` ，找出 `nums` 的下一个排列。

必须 **原地** 修改，只允许使用额外常数空间。

**示例1：**

```
输入：nums = [1,2,3]
输出：[1,3,2]
```

**示例2：**

```
输入：nums = [3,2,1]
输出：[1,2,3]
```

**示例3：**

```
输入：nums = [1,1,5]
输出：[1,5,1]
```

## 代码

#### 方法：模拟 排序

##### 思路

强烈推荐！！：https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/

##### 代码

```java
import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }

        for (int i = length - 1; i >= 1; i--) {
            // 从后往前找到相邻升序
            if (nums[i] > nums[i - 1]) {
                for (int j = length - 1; j >= i; j--) {
                    // 找到从右往左第一个大于nums[i - 1]的数，并交换
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, i, length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 2, 1};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        
        solution.nextPermutation(nums);
        
        System.out.println("Output: " + Arrays.toString(nums));
    }
}
```

##### 复杂度分析

- 时间复杂度：O(N)。
- 空间复杂度：O(1)。