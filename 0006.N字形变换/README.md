# [6.N字形变换](https://leetcode.cn/problems/zigzag-conversion/)

`时间：2023.6.20`

## 题目

将一个给定字符串 `s` 根据给定的行数 `numRows` ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 `"PAYPALISHIRING"` 行数为 `3` 时，排列如下：

```
P   A   H   N
A P L S I I G
Y   I   R
```

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：`"PAHNAPLSIIGYIR"`。

请你实现这个将字符串进行指定行数变换的函数：

```
string convert(string s, int numRows);
```

**示例1：**

```
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
```

**示例2：**

```
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
```

**示例3：**

```
输入：s = "A", numRows = 1
输出："A"
```

## 代码

#### 方法：动态规划

##### 思路

- **题目理解**
  - 字符串s是以Z字形为顺序存储的字符串，目标是按行打印。
  - 设numRows行字符串分别为s1,s2,...,sn，则容易发现：按顺序遍历字符串s时，每个字符c在Z字形中对应的**行索引**先从s1增大至sn，再从sn减小至s1，如此反复。
  - 因此，解决方案为：模拟这个行索引的变化，在遍历s中把每个字符填到正确的行res[i]。.
- **算法流程**：按顺序遍历字符串s；
  - res[i] += c：把每个字符c填入对应行si；
  - i += flag：更新当前字符c对应的行索引；
  - falg = - flag：在达到Z字形转折点时，执行反向。

##### 代码

```java
import java.util.ArrayList;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        ArrayList<StringBuilder> myList = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++)
            myList.add(new StringBuilder());
        int count = 0, flag = -1;
        for (int i = 0; i < s.length(); i++) {
            myList.get(count).append(s.charAt(i));
            if (count == 0 || count == numRows - 1)
                flag = -flag;
            count += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(myList.get(i));
        }

        return sb.toString();
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)，遍历一遍字符串`s`。
- 空间复杂度：O(n)，各行字符串共占用O(n)额外空间。
