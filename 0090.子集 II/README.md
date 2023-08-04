# [90.子集 II](https://leetcode.cn/problems/subsets-ii/)

`时间：2023.8.4`

## 题目

给你一个整数数组 `nums` ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 **不能** 包含重复的子集。返回的解集中，子集可以按 **任意顺序** 排列。

**示例1：**

```
输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
```

**示例2：**

```
输入：nums = [0]
输出：[[],[0]]
```

## 代码

#### 方法：递归法实现子集枚举，同时去重

##### 思路

详见：[90. 子集 II - 力扣（LeetCode）](https://leetcode.cn/problems/subsets-ii/solutions/690549/zi-ji-ii-by-leetcode-solution-7inq/)

[90. 子集 II - 力扣（LeetCode）](https://leetcode.cn/problems/subsets-ii/solutions/690866/90-zi-ji-iiche-di-li-jie-zi-ji-wen-ti-ru-djmf/)

关于Java代码subsetsWithDupHelper for循环中if判断条件为什么是!used[i - 1]的理解： 表面上，continue条件应该是前一个元素被使用过，这里跟正常逻辑相悖； 仔细想想，如果used[i - 1]被标记为1， 说明该元素刚被使用过且未回溯，那么就算第i个元素和第i-1个元素相等，也可以放心大胆地加到sublist里面，因为加入以后一定比之前元素多一个，不会重复； 相反，如果used[i - 1]被标记为0， 因为现在已经访问到之后的元素了，之前元素一定是被访问过的，那么被标0只有一种可能，就是该元素已经被回溯过了，此时必须跳过当前元素，否则会重复，因为list里面已经有相同的sublist。

##### 代码

```java
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(false, 0, nums, temp, result);
        return result;
    }

    public void dfs(boolean choosePre, int cur, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 不选当前元素，choosePre为false
        dfs(false, cur + 1, nums, temp, result);
        // 判断是否与前一个元素相同且未选前一个元素，没选说明递归前一层已经选过了
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        // 选当前元素，choosePre为true
        temp.add(nums[cur]);
        dfs(true, cur + 1, nums, temp, result);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        System.out.println(subsets);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n*2^n)。
- 空间复杂度：O(n)。