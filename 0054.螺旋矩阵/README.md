# [54.螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/)

`时间：2023.7.15`

## 题目

给你一个 `m` 行 `n` 列的矩阵 `matrix` ，请按照 **顺时针螺旋顺序** ，返回矩阵中的所有元素。

**示例1：**

```
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```

**示例2：**

```
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

## 代码

#### 方法：模拟

##### 思路

这里的方法不需要记录已经走过的路径，所以执行用时和内存消耗都相对较小

1. 首先设定上下左右边界
2. 其次向右移动到最右，此时第一行因为已经使用过了，可以将其从图中删去，体现在代码中就是重新定义上边界
3. 判断若重新定义后，上下边界交错，表明螺旋矩阵遍历结束，跳出循环，返回答案
4. 若上下边界不交错，则遍历还未结束，接着向下向左向上移动，操作过程与第一，二步同理
5. 不断循环以上步骤，直到某两条边界交错，跳出循环，返回答案

##### 代码

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        // 若数组为空，直接返回答案
        if (matrix.length == 0) {
            return result;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int upper = 0;
        int down = matrix.length - 1;
        while (true) {
            // 向右移动直到最右
            for (int i = left; i <= right; i++) {
                result.add(matrix[upper][i]);
            }
            // 重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
            if (++upper > down) {
                break;
            }
            // 向下
            for (int i = upper; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            // 重新设定右边界
            if (--right < left) {
                break;
            }
            // 向左
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            // 重新设定下边界
            if (--down < upper) {
                break;
            }
            // 向上
            for (int i = down; i >= upper; i--) {
                result.add(matrix[i][left]);
            }
            // 重新设定左边界
            if (++left > right) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> output = solution.spiralOrder(matrix);
        System.out.println("Input matrix: " + Arrays.deepToString(matrix));
        System.out.println("Output: " + output);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(m * n)。
- 空间复杂度：O(m * n)。