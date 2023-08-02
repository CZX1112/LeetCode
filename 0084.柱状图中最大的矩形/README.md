# [84.柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/)

`时间：2023.8.2`

## 题目

给定 `n` 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

**示例1：**

![example1](pictures/example1.jpg)

```
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
```

**示例2：**

![example2](pictures/example2.jpg)

```
输入： heights = [2,4]
输出： 4
```

## 代码

#### 方法：单调栈

##### 思路

强烈推荐！！！！：https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/108083/84-by-ikaruga/

https://www.bilibili.com/video/BV1Ns4y1o7uB/?spm_id_from=333.788&vd_source=7f6ba21197bdeac9f512077e3b57e148

1. 对于一个高度，如果能得到向左和向右的边界
2. 那么就能对每个高度求一次面积
3. 遍历所有高度，即可得出最大面积
4. 使用单调栈，在出栈操作时得到前后边界并计算面积

##### 代码

```java
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        只做单调栈思路:参考"编程狂想曲"思路比较好理解
        1.核心思想:求每条柱子可以向左右延伸的长度->矩形最大宽度;矩形的高->柱子的高度
            计算以每一根柱子高度为高的矩形面积,维护面积最大值
        2.朴素的想法:遍历每一根柱子的高度然后向两边进行扩散找到最大宽度
        3.单调栈优化:因为最终的目的是寻找对应柱子height[i]右边首个严格小于height[i]的柱子height[r]
            左边同理找到首个严格小于height[i]的柱子height[l]
            维护一个单调递增栈(栈底->栈顶),那么每当遇到新加入的元素<栈顶便可以确定栈顶柱子右边界
            而栈顶柱子左边界就是栈顶柱子下面的柱子(<栈顶柱子)
            左右边界确定以后就可以进行面积计算与维护最大面积
        时间复杂度:O(N),空间复杂度:O(N)
        */

        // 引入哨兵
        // 哨兵的作用是 将最后的元素出栈计算面积 以及 将开头的元素顺利入栈
        // len为引入哨兵后的数组长度
        int len = heights.length + 2;
        int[] newheights = new int[len];
        newheights[0] = newheights[len - 1] = 0;
        // [1,2,3]->[0,1,2,3,0]
        for (int i = 1; i < len - 1; i++) {
            newheights[i] = heights[i - 1];
        }
        // 单调递增栈:存储每个柱子的索引,使得这些索引对应的柱子高度单调递增
        Deque<Integer> mystack = new ArrayDeque<>();
        // 最大矩形面积
        int result = 0;
        // 遍历哨兵数组
        for (int i = 0; i < len; i++) {
            // 栈不为空且当前柱子高度<栈顶索引对应的柱子高度
            // 说明栈顶元素的右边界已经确定,就是索引为i的柱子(不含)
            // 此时将栈顶元素出栈,栈顶矩形左边界为栈顶元素下面的索引(首个小于栈顶)
            while (!mystack.isEmpty() && newheights[i] < newheights[mystack.peek()]) {
                // 栈顶索引出栈并记录
                int mid = mystack.peek();
                mystack.pop();
                if (mystack.isEmpty()) {
                    break;
                }
                int left = mystack.peek();
                int right = i;
                // 栈顶索引对应的柱子高度就是矩形的高度
                int height = newheights[mid];
                // 计算出栈顶元素矩形的宽度如(0,1,2)->[1,2,1],两边都不包含
                // 因此右索引-左索引-1=矩形宽度
                int width = right - left - 1;
                // 计算矩形面积
                // 维护矩形面积最大值
                result = Math.max(result, height * width);
            }
            // 每当弹出一个索引就计算一个矩形面积
            // 直到当前元素>=栈顶元素(或者栈为空)时,栈顶柱子的右边界还没确定
            // 因此当前元素索引入栈即可
            mystack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heigths = {2, 4};
        Solution sol = new Solution();
        int result = sol.largestRectangleArea(heigths);
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。n为数组长度，我们最多遍历该数组一次。
- 空间复杂度：O(n)。