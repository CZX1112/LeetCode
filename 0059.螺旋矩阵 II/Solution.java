import java.util.Arrays;

class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1;
        int top = 0, down = n - 1;
        int[][] result = new int[n][n];
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = left; i <= right; i++) result[top][i] = num++;     // left to right
            top++;
            for (int i = top; i <= down; i++) result[i][right] = num++;     // top to down
            right--;
            for (int i = right; i >= left; i--) result[down][i] = num++;    // right to left
            down--;
            for (int i = down; i >= top; i--) result[i][left] = num++;      // down to top
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 3;
        int[][] matrix = solution.generateMatrix(n);

        System.out.println("Generated Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}