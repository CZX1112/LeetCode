# [26.删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)

`时间：2023.7.5`

## 题目

给你一个 **升序排列** 的数组 `nums` ，请你 **原地** 删除重复出现的元素，使每个元素 **只出现一次** ，返回删除后数组的新长度。元素的 **相对顺序** 应该保持 **一致** 。然后返回 `nums` 中唯一元素的个数。

考虑 `nums` 的唯一元素的数量为 `k` ，你需要做以下事情确保你的题解可以被通过：

更改数组 `nums` ，使 `nums` 的前 `k` 个元素包含唯一元素，并按照它们最初在 `nums` 中出现的顺序排列。`nums` 的其余元素与 `nums` 的大小不重要。
返回 `k` 。

**示例1：**

```
输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
```

**示例2：**

```
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
```

## 代码

#### 方法：双指针

##### 思路

首先注意数组是有序的，那么重复的元素一定会相邻。

要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。

考虑用 `2` 个指针，一个在前记作 `p`，一个在后记作 `q`，算法流程如下：

比较 `p` 和 `q` 位置的元素是否相等。

如果相等，`q` 后移 `1` 位

如果不相等，将 `q` 位置的元素复制到 `p + 1` 位置上，`p` 后移一位，`q` 后移 `1` 位

重复上述过程，直到 `q` 等于数组长度。

返回 `p + 1`，即为新数组长度。

##### 代码

```java
class Solution {
    // 双指针法
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1
        int[] nums1 = {1, 1, 2};
        int length1 = solution.removeDuplicates(nums1);
        System.out.println("Length: " + length1);
        printArray(nums1, length1);

        // 测试用例2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length2 = solution.removeDuplicates(nums2);
        System.out.println("Length: " + length2);
        printArray(nums2, length2);
    }

    // 辅助方法：打印数组的前 n 个元素
    private static void printArray(int[] nums, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)，其中n是数组的长度。
- 空间复杂度：O(1)。