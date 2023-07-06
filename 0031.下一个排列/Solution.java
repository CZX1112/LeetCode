import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }

        for (int i = length - 1; i >= 1; i--) {
            // 从后往前找到相邻升序
            if (nums[i] > nums[i - 1]) {
                for (int j = length - 1; j >= i; j--) {
                    // 找到从右往左第一个大于nums[i - 1]的数，并交换
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, i, length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 2, 1};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        
        solution.nextPermutation(nums);
        
        System.out.println("Output: " + Arrays.toString(nums));
    }
}