# [0118.杨辉三角](https://leetcode.cn/problems/pascals-triangle-ii/)

`时间：2023.8.23`

## 题目

给定一个非负索引 `rowIndex`，返回「杨辉三角」的第 `rowIndex` 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。

**示例1：**

```
输入: rowIndex = 3
输出: [1,3,3,1]
```

**示例2：**

```
输入: rowIndex = 0
输出: [1]
```

**示例3：**

```
输入: rowIndex = 1
输出: [1,1]
```

## 代码

#### 方法：数学 模拟

##### 思路

通过简单的循环计算每行的元素，推入结果数组即可，其中：

1. 每行的第一个和最后一个元素是1
2. 其他元素等于上一行的当前index-1的值加上上一行的当前index的值

还能继续优化，只用两个数组pre，cur，滚动数组法。不想写了，有个思路就行了。

##### 代码

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();
        oneList.add(1);
        result.add(oneList);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    temp.add(sum);
                }
            }
            result.add(temp);
        }
        return result.get(rowIndex);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> result = sol.getRow(3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
```

##### 复杂度分析

- 时间复杂度：O(rowIndex^2)。
- 空间复杂度：O(⁡1)。