import java.util.Arrays;

class Solution {
    // 双指针
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int left = 0, right = 0;
        while (right < length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int length = solution.removeElement(nums, val);
        System.out.println("Output: " + length + ", nums = " + Arrays.toString(nums));
    }
}