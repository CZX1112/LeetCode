// import java.util.HashMap;
// import java.util.Map;

class Solution {
    // 法一：哈希表法
    // public int singleNumber(int[] nums) {
    //     Map<Integer, Integer> hashMap = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (hashMap.containsKey(nums[i])) {
    //             hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
    //         }
    //         else {
    //             hashMap.put(nums[i], 1);
    //         }
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (hashMap.get(nums[i]) == 1) {
    //             return nums[i];
    //         }
    //     }
    //     return 0;
    // }

    //法二：位运算异或法
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4,1,2,1,2};
        int result = sol.singleNumber(nums);
        System.out.println("result = " + result);
    }
}