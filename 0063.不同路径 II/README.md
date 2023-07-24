# [63.不同路径 II](https://leetcode.cn/problems/unique-paths-ii/)

`时间：2023.7.24`

## 题目

一个机器人位于一个 `m x n` 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 `1` 和 `0 来表示。

**示例1：**

![1](pictures/robot1.jpg)

```
输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
```

**示例2：**

![2](pictures/robot2.jpg)

```
输入：obstacleGrid = [[0,1],[0,0]]
输出：1
```

## 代码

#### 方法：动态规划

##### 思路

![3](pictures/1.png)

![4](pictures/2.png)

![5](pictures/3.png)

##### 代码

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 定义 dp 数组并初始化第 1 行和第 1 列
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Create the input matrix: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int result = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Output: " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(mn)。
- 空间复杂度：O(mn)。