# [70.爬楼梯](https://leetcode.cn/problems/climbing-stairs/)

`时间：2023.7.27`

## 题目

假设你正在爬楼梯。需要 `n` 阶你才能到达楼顶。

每次你可以爬 `1` 或 `2` 个台阶。你有多少种不同的方法可以爬到楼顶呢？

**示例1：**

```
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
```

**示例2：**

```
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
```

## 代码

#### 方法：斐波那契数列 + 动态规划

##### 思路

最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：

`f(x)=f(x−1)+f(x−2)`

##### 代码

```java
class Solution {
    // 斐波那契数列 动态规划
    public int climbStairs(int n) {
        int front = 0, frofront = 0;
        int sum = 1;
        for (int i = 0; i < n; i++) {
            frofront = front;
            front = sum;
            sum = front + frofront;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.climbStairs(3);
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。循环执行n次。
- 空间复杂度：O(1)。