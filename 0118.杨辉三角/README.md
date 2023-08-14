# [0118.杨辉三角](https://leetcode.cn/problems/path-sum/)

`时间：2023.8.14`

## 题目

给定一个非负整数 `numRows`，生成「杨辉三角」的前 `numRows` 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。

**示例1：**

```
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```

**示例2：**

```
输入: numRows = 1
输出: [[1]]
```

## 代码

#### 方法：数学 模拟

##### 思路

通过简单的循环计算每行的元素，推入结果数组即可，其中：

1. 每行的第一个和最后一个元素是1
2. 其他元素等于上一行的当前index-1的值加上上一行的当前index的值

##### 代码

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();
        oneList.add(1);
        result.add(oneList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                }
                else {
                    int sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    temp.add(sum);
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> result = sol.generate(5);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
```

##### 复杂度分析

- 时间复杂度：O(numRows^2)。
- 空间复杂度：O(⁡1)。