import java.util.HashMap;

class Solution {
    // 法一：暴力枚举
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        int[] number = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    number[0] = i;
                    number[1] = j;
                    return number;
                }
            }
        }
        return number;
    }
    // 法二：哈希表法
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum2(numbers, target);
        System.out.println(result[0] + "," + result[1]);
    }
}