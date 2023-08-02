# [88.合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/)

`时间：2023.8.2`

## 题目

给你两个按 **非递减顺序** 排列的整数数组 `nums1` 和 `nums2`，另有两个整数 `m` 和 `n` ，分别表示 `nums1` 和 `nums2` 中的元素数目。

请你 **合并** `nums2` 到 `nums1` 中，使合并后的数组同样按 **非递减顺序** 排列。

**注意：**最终，合并后数组不应由函数返回，而是存储在数组 `nums1` 中。为了应对这种情况，`nums1` 的初始长度为 `m + n`，其中前 `m` 个元素表示应合并的元素，后 `n` 个元素为 `0` ，应忽略。`nums2` 的长度为 `n` 。

**示例1：**

```
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
```

**示例2：**

```
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
```

**示例3：**

```
输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
```

## 代码

#### 方法：双指针法，从尾到头

##### 思路

从后往前修改，即可实现原地修改。

##### 代码

```java
import java.util.Arrays;

class Solution {
    // 双指针法，从尾到头
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int locate = m + n - 1;
        int p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[locate] = nums1[p1];
                p1--;
            }
            else {
                nums1[locate] = nums2[p2];
                p2--;
            }
            locate--;
        }
        for (int i = p1; i >= 0; i--) {
            nums1[locate] = nums1[i];
            locate--;
        }
        for (int i = p2; i >= 0; i--) {
            nums1[locate] = nums2[i];
            locate--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println("Input nums1: " + Arrays.toString(nums1));
        System.out.println("Expected Output: [1, 2, 2, 3, 5, 6]");
    }
}
```

##### 复杂度分析

- 时间复杂度：O(m+n)。
- 空间复杂度：O(1)。原地修改