# [16.最接近的三数之和](https://leetcode.cn/problems/3sum-closest/)

`时间：2023.7.3`

## 题目

给你一个长度为 `n` 的整数数组 `nums` 和一个目标值 `target` 。请你从 `nums` 中选出三个整数，使它们的和与 `target` 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。

**示例1：**

```
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
```

**示例2：**

```
输入：nums = [0,0,0], target = 1
输出：0
```

## 代码

#### 方法：排序+双指针

##### 思路

- 本题目因为要计算三个数，如果靠暴力枚举的话时间复杂度会到 O(n^3) ，需要降低时间复杂度
- 首先进行数组排序，时间复杂度 O(nlogn)
- 在数组 `nums` 中，进行遍历，每遍历一个值利用其下标`i`，形成一个固定值 `nums[i]`
- 再使用前指针指向 `start = i + 1` 处，后指针指向 `end = nums.length - 1` 处，也就是结尾处
- 根据 `sum = nums[i] + nums[start] + nums[end]` 的结果，判断 `sum` 与目标 `target` 的距离，如果更近则更新结果 `ans`
- 同时判断 `sum` 与 `target` 的大小关系，因为数组有序，如果 `sum > target` 则 `end--`，如果 `sum < target` 则 `start++`，如果 `sum == target` 则说明距离为 0 直接返回结果

##### 代码

```java
class Solution {
    //排序+双指针法
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 100000000;
        int length = nums.length;
        for (int left = 0; left < length; left++) {
            int mid = left + 1, right = length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == target)
                    return sum;
                else if (sum > target)
                    right--;
                else
                    mid++;
                result = Math.abs(target - result) > Math.abs(target - sum) ? sum : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        Solution sol = new Solution();
        int result = sol.threeSumClosest(nums, target);
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(N^2)，其中N是数组nums的长度。
- 空间复杂度：O(1)。