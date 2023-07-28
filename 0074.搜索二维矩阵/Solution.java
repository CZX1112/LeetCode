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