# [0171.Excel 表列序号](https://leetcode.cn/problems/excel-sheet-column-number/)

`时间：2023.11.10`

## 题目

给你一个字符串 `columnTitle` ，表示 Excel 表格中的列名称。返回 **该列名称对应的列序号** 。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 

**示例1：**

```
输入: columnTitle = "A"
输出: 1
```

**示例2：**

```
输入: columnTitle = "AB"
输出: 28
```

**示例3：**

```
输入: columnTitle = "ZY"
输出: 701
```

## 代码

#### 方法：进制转换

##### 思路

- 标签：字符串遍历，进制转换
- 初始化结果 `ans = 0`，遍历时将每个字母与 A 做减法，因为 A 表示 1，所以减法后需要每个数加 1，计算其代表的数值 `num = 字母 - ‘A’ + 1`
- 因为有 26 个字母，所以相当于 26 进制，每 26 个数则向前进一位
- 所以每遍历一位则 `ans = ans * 26 + num`
- 以 ZY 为例，Z 的值为 `26`，Y 的值为 `25`，则结果为 `26 * 26 + 25=701`

##### 代码

```c++
#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int titleToNumber(string columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.size() - 1; i >= 0; i--) {
            int k = columnTitle[i] - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }
};

int main() {
    Solution sol;
    string columnTitle = "AB";
    int result = sol.titleToNumber(columnTitle);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}
```

##### 复杂度分析

- 时间复杂度：O(n)。
- 空间复杂度：O(n)。
