# [74.搜索二维矩阵](https://leetcode.cn/problems/search-a-2d-matrix/)

`时间：2023.7.28`

## 题目

给你一个满足下述两条属性的 `m x n` 整数矩阵：

- 每行中的整数从左到右按非递减顺序排列。
- 每行的第一个整数大于前一行的最后一个整数。
给你一个整数 `target` ，如果 `target` 在矩阵中，返回 `true` ；否则，返回 `false` 。

**示例1：**

```
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true
```

**示例2：**

```
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false
```

## 代码

#### 方法：

##### 思路

根据题意已知，二维数组从左往右递增，从上往下递增，所以得出以下结论：

1. 某列的某个数字，该数之上的数字，都比其小；
2. 某行的某个数字，该数右侧的数字，都比其大；

所以，解题流程如下所示：

1. 以二维数组左下角为原点，建立直角坐标轴。
2. 若当前数字大于了查找数，查找往上移一位。
3. 若当前数字小于了查找数，查找往右移一位。

##### 代码

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = m - 1, col = 0;
        while (true) {
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] > target) {
                row--;
            }
            else {
                col++;
            }
            if (row < 0 || col >= n) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;

        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Output: " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：最坏O(mn)。
- 空间复杂度：O(1)。