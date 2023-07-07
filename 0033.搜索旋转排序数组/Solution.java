class Solution {
    public int search(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 0—mid有序
            if (nums[0] <= nums[mid]) {
                // 夹在有序那串中间
                if (target >= nums[0] && target <= nums[mid]) {
                    right = mid;
                }
                else {
                    left = mid;
                }
            }
            // mid—nums.length-1有序
            else {
                // 夹在有序那串中间
                if (target >= nums[mid] && target <= nums[nums.length - 1]) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println("输出：" + result); // 输出：4
    }
}