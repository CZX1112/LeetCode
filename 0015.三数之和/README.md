# [15.三数之和](https://leetcode.cn/problems/3sum/)

`时间：2023.7.3`

## 题目

给你一个整数数组 `nums` ，判断是否存在三元组 `[nums[i], nums[j], nums[k]]` 满足 `i != j`、`i != k` 且 `j != k` ，同时还满足 `nums[i] + nums[j] + nums[k] == 0` 。请

你返回所有和为 `0` 且不重复的三元组。

**注意：**答案中不可以包含重复的三元组。

**示例1：**

```
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
```

**示例2：**

```
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
```

**示例3：**

```
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
```

## 代码

#### 方法：排序+双指针

##### 思路

- 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i] 后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为0，满足则添加进结果集。
- 如果 nums[i] 大于0，则三数之和必然无法等于 0，结束循环
- 如果 nums[i] == nums[i - 1]，则说明该数字重复，会导致结果重复，所以应该跳过
- 当 sum == 0 时，nums[L] == nums[L + 1] 则会导致结果重复，应该跳过，L++
- 当 sum == 0 时，nums[R] == nums[R - 1] 则会导致结果重复，应该跳过，R--

##### 代码

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int left = 0; left < length; left++) {
            if (nums[left] > 0)
                break;
            if (left > 0 && nums[left] == nums[left - 1])
                continue;
            int mid = left + 1, right = length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    while (mid < right && nums[mid] == nums[mid + 1])
                        mid = mid + 1;
                    while (mid < right && nums[right] == nums[right - 1])
                        right = right - 1;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    result.add(list);
                    mid++;
                    right--;
                }
                else if (sum > 0)
                    right--;
                else
                    mid++;
            }
        }
        return result;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(N^2)，其中N是数组nums的长度。
- 空间复杂度：O(1)。