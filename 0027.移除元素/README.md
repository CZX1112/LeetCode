# [27.移除元素](https://leetcode.cn/problems/remove-element/)

`时间：2023.7.6`

## 题目

给你一个数组 `nums` 和一个值 `val` ，请你 **原地** 移除所有数值等于 `val` 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 `O(1)` 额外空间并 **原地 修改输入数组**。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

**示例1：**

```
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
```

**示例2：**

```
输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3]
解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
```

## 代码

#### 方法：双指针

##### 思路

由于题目要求删除数组中等于 `val` 的元素，因此输出数组的长度一定小于等于输入数组的长度，我们可以把输出的数组直接写在输入数组上。可以使用双指针：右指针 `right` 指向当前将要处理的元素，左指针 `left` 指向下一个将要赋值的位置。

- 如果右指针指向的元素不等于 `val`，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
- 如果右指针指向的元素等于 `val`，它不能在输出数组里，此时左指针不动，右指针右移一位。

整个过程保持不变的性质是：区间 `[0,left)` 中的元素都不等于 `val`。当左右指针遍历完输入数组以后，`left` 的值就是输出数组的长度。

这样的算法在最坏情况下（输入数组中没有元素等于 `val`），左右指针各遍历了数组一次。

##### 代码

```java
import java.util.Arrays;

class Solution {
    // 双指针
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int left = 0, right = 0;
        while (right < length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int length = solution.removeElement(nums, val);
        System.out.println("Output: " + length + ", nums = " + Arrays.toString(nums));
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)，其中n是数组的长度。
- 空间复杂度：O(1)。