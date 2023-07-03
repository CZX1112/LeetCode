import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    // 排序+双指针法
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int left = 0; left < length; left++) {
            if (nums[left] > 0)
                break;
            if (left > 0 && nums[left] == nums[left - 1])
                continue;
            int mid = left + 1, right = length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    while (mid < right && nums[mid] == nums[mid + 1])
                        mid = mid + 1;
                    while (mid < right && nums[right] == nums[right - 1])
                        right = right - 1;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    result.add(list);
                    mid++;
                    right--;
                }
                else if (sum > 0)
                    right--;
                else
                    mid++;
            }
        }
        return result;
    }
}