# [62.不同路径](https://leetcode.cn/problems/unique-paths/)

`时间：2023.7.19`

## 题目

一个机器人位于一个 `m x n` 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

**示例1：**

```
输入：m = 3, n = 7
输出：28
```

**示例2：**

```
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
```

**示例3：**

```
输入：m = 7, n = 3
输出：28
```

**示例4：**

```
输入：m = 3, n = 3
输出：6
```

## 代码

#### 方法：动态规划

##### 思路

我们令 `dp[i][j]` 是到达 `i, j` 最多路径

动态方程：`dp[i][j] = dp[i-1][j] + dp[i][j-1]`

注意，对于第一行 `dp[0][j]`，或者第一列 `dp[i][0]`，由于都是在边界，所以只能为 `1`

优化：因为我们每次只需要 `dp[i-1][j],dp[i][j-1]`

##### 代码

```java
class Solution {
    // 动态规划
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 3;
        int n = 7;
        int numPaths = solution.uniquePaths(m, n);
        System.out.println("Number of Unique Paths: " + numPaths);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(m * n)。
- 空间复杂度：O(m * n)。