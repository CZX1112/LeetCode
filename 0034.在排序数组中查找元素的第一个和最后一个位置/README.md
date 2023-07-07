# [34.在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

`时间：2023.7.7`

## 题目

给你一个按照非递减顺序排列的整数数组 `nums`，和一个目标值 `target`。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 `target`，返回 `[-1, -1]`。

你必须设计并实现时间复杂度为 `O(log n)` 的算法解决此问题。

**示例1：**

```
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
```

**示例2：**

```
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
```

**示例3：**

```
输入：nums = [], target = 0
输出：[-1,-1]
```

## 代码

#### 方法：二分查找：红蓝边界，B站方法

##### 思路

强烈推荐！！：https://www.bilibili.com/video/BV1d54y1q7k7/?spm_id_from=333.337.search-card.all.click&vd_source=7f6ba21197bdeac9f512077e3b57e148

通过设置条件，获得第一个和最后一个指定数的位置。

##### 代码

```java
class Solution {
    // 二分查找：找到第一个和最后一个指定数的位置
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target + 1);
        if (left == nums.length - 1 || nums[left + 1] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left + 1, right};
    }

    public int binarySearch(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        
    }
}
```

##### 复杂度分析

- 时间复杂度：O(log N)。
- 空间复杂度：O(1)。