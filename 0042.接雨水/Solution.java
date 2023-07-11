class Solution {
    // 法一：按列求和
    // public int trap(int[] height) {
    //     int sum = 0;
    //     // 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
    //     for (int i = 1; i < height.length - 1; i++) {
    //         int max_left = 0;
    //         // 找出左边最高
    //         for (int j = i - 1; j >= 0; j--) {
    //             if (height[j] > max_left) {
    //                 max_left = height[j];
    //             }
    //         }
    //         int max_right = 0;
    //         // 找出右边最高
    //         for (int j = i + 1; j < height.length; j++) {
    //             if (height[j] > max_right) {
    //                 max_right = height[j];
    //             }
    //         }
    //         // 找出两端较小的
    //         int min = Math.min(max_left, max_right);
    //         // 只有较小的一段大于当前列的高度才会有水，其他情况不会有水
    //         if (min > height[i]) {
    //             sum += min - height[i];
    //         }
    //     }
    //     return sum;
    // }

    // 法二：动态规划（法一的改进）
    public int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        // 求左边最高列，从左到右
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        // 求右边最高列，从右到左
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height = {4, 2, 0, 3, 2, 5};
        int result = solution.trap(height);
        System.out.println("Output: " + result); // Expected output: 9
    }
}