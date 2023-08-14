import java.util.List;
import java.util.ArrayList;

class Solution {
    // 方法一：空间复杂度 O(n^2)
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        int length = triangle.size();
        // 第一行，边界情况
        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(triangle.get(0).get(0));
        dp.add(rowOne);
        for (int i = 1; i < length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                // 头只能通过上一行的头得到
                if (j == 0) {
                    temp.add(triangle.get(i).get(j) + dp.get(i - 1).get(j));
                }
                // 尾只能通过上一行的尾得到
                else if (j == i) {
                    temp.add(triangle.get(i).get(j) + dp.get(i - 1).get(j - 1));
                }
                // 其他元素动规得到
                else {
                    temp.add(triangle.get(i).get(j) + Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
                }
            }
            dp.add(temp);
        }
        int minSum = dp.get(length - 1).get(0);
        for (int i = 1; i < dp.get(length - 1).size(); i++) {
            minSum = Math.min(minSum, dp.get(length - 1).get(i));
        }
        return minSum;
    }
}