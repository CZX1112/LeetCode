class Solution {
    // 方法一：使用辅助数组
    // public void rotate(int[][] matrix) {
    //     int length = matrix.length;
    //     int[][] matrix_new = new int[length][length];
    //     for (int i = 0; i < length; i++) {
    //         for (int j = 0; j < length; j++) {
    //             matrix_new[j][length - i - 1] = matrix[i][j];
    //         }
    //     }
    //     for (int i = 0; i < length; i++) {
    //         for (int j = 0; j < length; j++) {
    //             matrix[i][j] = matrix_new[i][j];
    //         }
    //     }
    // }

    // 方法二：用翻转代替旋转
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        // 水平翻转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        System.out.println("原始矩阵:");
        printMatrix(matrix);
        solution.rotate(matrix);
        System.out.println("旋转后的矩阵:");
        printMatrix(matrix);
    }

    // 辅助方法，用于打印矩阵
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}