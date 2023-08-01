class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5};
        Solution sol = new Solution();
        int slow = sol.removeDuplicates(nums);
        for (int i = 0; i < slow; i++) {
            System.out.println(nums[i]);
        }
    }
}