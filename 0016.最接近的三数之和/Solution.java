import java.util.Arrays;

class Solution {
    //排序+双指针法
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 100000000;
        int length = nums.length;
        for (int left = 0; left < length; left++) {
            int mid = left + 1, right = length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == target)
                    return sum;
                else if (sum > target)
                    right--;
                else
                    mid++;
                result = Math.abs(target - result) > Math.abs(target - sum) ? sum : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        Solution sol = new Solution();
        int result = sol.threeSumClosest(nums, target);
        System.out.println("result = " + result);
    }
}