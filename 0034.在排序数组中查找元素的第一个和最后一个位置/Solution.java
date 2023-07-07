import java.util.Arrays;

class Solution {
    // 二分查找：找到第一个和最后一个指定数的位置
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target + 1);
        if (left == nums.length - 1 || nums[left + 1] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left + 1, right};
    }

    public int binarySearch(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("输出：" + Arrays.toString(result)); // 输出：[3, 4]
    }
}