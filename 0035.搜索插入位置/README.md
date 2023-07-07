# [35.搜索插入位置](https://leetcode.cn/problems/search-insert-position/)

`时间：2023.7.7`

## 题目

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 `O(log n)` 的算法。

**示例1：**

```
输入: nums = [1,3,5,6], target = 5
输出: 2
```

**示例2：**

```
输入: nums = [1,3,5,6], target = 2
输出: 1
```

**示例3：**

```
输入: nums = [1,3,5,6], target = 7
输出: 4
```

## 代码

#### 方法：二分查找：红蓝边界，B站方法

##### 思路

强烈推荐！！：https://www.bilibili.com/video/BV1d54y1q7k7/?spm_id_from=333.337.search-card.all.click&vd_source=7f6ba21197bdeac9f512077e3b57e148

##### 代码

```java
class Solution {
    // 二分查找：红蓝边界，B站方法
    public int searchInsert(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = solution.searchInsert(nums, target);
        System.out.println("输出：" + result); // 输出：2
    }
}
```

##### 复杂度分析

- 时间复杂度：O(log N)。
- 空间复杂度：O(1)。