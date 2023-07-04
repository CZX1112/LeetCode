# [20.有效的括号](https://leetcode.cn/problems/valid-parentheses/)

`时间：2023.7.4`

## 题目

给定一个只包括 `'('，')'，'{'，'}'，'['，']'` 的字符串 `s` ，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。
3. 每个右括号都有一个对应的相同类型的左括号。

**示例1：**

```
输入：s = "()"
输出：true
```

**示例2：**

```
输入：s = "()[]{}"
输出：true
```

**示例3：**

```
输入：s = "(]"
输出：false
```

## 代码

#### 方法：栈

##### 思路

判断括号的有效性可以使用「栈」这一数据结构来解决。

我们遍历给定的字符串s。当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。**由于后遇到的左括号要先闭合**，因此我们可以将这个左括号放入栈顶。

当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。如果不是相同的类型，或者栈中并没有左括号，那么字符串 s 无效，返回False。为了快速判断括号的类型，我们可以使用哈希表存储每一种括号。哈希表的键为右括号，值为相同类型的左括号。

在遍历结束后，如果栈中没有左括号，说明我们将字符串 s 中的所有左括号闭合，返回 
True，否则返回 False。

注意到有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 False，省去后续的遍历判断过程。

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

- 时间复杂度：O(N)，其中N是字符串s的长度。
- 空间复杂度：O(n+t)。其中t表示字符集，本题中字符串只包含6种括号，t=6。栈中的字符数量为O(N)，相加即可得到总空间复杂度。