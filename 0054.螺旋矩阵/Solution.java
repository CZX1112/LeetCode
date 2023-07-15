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