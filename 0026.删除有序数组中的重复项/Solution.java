class Solution {
    // 双指针法
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1
        int[] nums1 = {1, 1, 2};
        int length1 = solution.removeDuplicates(nums1);
        System.out.println("Length: " + length1);
        printArray(nums1, length1);

        // 测试用例2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length2 = solution.removeDuplicates(nums2);
        System.out.println("Length: " + length2);
        printArray(nums2, length2);
    }

    // 辅助方法：打印数组的前 n 个元素
    private static void printArray(int[] nums, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}