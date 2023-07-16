class Solution {
    // 贪心算法即可
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightmost = 0;
        for (int i = 0; i < length; i++) {
            // i位置无法到达
            if (i > rightmost) {
                return false;
            }
            // 动态维护最远距离
            rightmost = Math.max(rightmost, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,1,4};
        boolean result = solution.canJump(nums);
        System.out.println("result = " + result);
    }
}