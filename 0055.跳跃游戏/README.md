# [55.跳跃游戏](https://leetcode.cn/problems/jump-game/)

`时间：2023.7.16`

## 题目

给定一个非负整数数组 `nums` ，你最初位于数组的 **第一个下标** 。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标。

**示例1：**

```
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
```

**示例2：**

```
输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
```

## 代码

#### 方法：贪心算法

##### 思路

这里的方法不需要记录已经走过的路径，所以执行用时和内存消耗都相对较小

1. 如果某一个作为 **起跳点** 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 **起跳点**
2. 可以对每一个能作为 **起跳点** 的格子都尝试跳一次，把 **能跳到最远的距离** 不断更新
3. 如果可以一直跳到最后，就成功了

##### 代码

```java
class Solution {
    // 贪心算法即可
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightmost = 0;
        for (int i = 0; i < length; i++) {
            // i位置无法到达
            if (i > rightmost) {
                return false;
            }
            // 动态维护最远距离
            rightmost = Math.max(rightmost, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,1,4};
        boolean result = solution.canJump(nums);
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(1)。