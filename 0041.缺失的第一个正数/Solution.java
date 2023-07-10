import java.util.HashSet;

class Solution {
    // 法一：哈希表 空间O(n) 不符合空间复杂度要求
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;

        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int i = 0; i < length; i++) {
            hashset.add(nums[i]);
        }
        for (int i = 1; i <= length; i++) {
            if (!hashset.contains(i)) {
                return i;
            }
        }
        return length + 1;
    }

    // 法二：原地哈希，将数组视为哈希表
    // public int firstMissingPositive(int[] nums) {
    //     int length = nums.length;
    //     for (int i = 0; i < length; i++) {
    //         while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
    //             // 满足在指定范围内、并且没有放在正确的位置上，才交换
    //             int temp = nums[nums[i] - 1];
    //             nums[nums[i] - 1] = nums[i];
    //             nums[i] = temp;
    //         }
    //     }

    //     // 判断数组中的值不等于下标的那个数
    //     for (int i = 0; i < length; i++) {
    //         if (nums[i] != i + 1) {
    //             return i + 1;
    //         }
    //     }

    //     // 都正确则返回数组长度 + 1
    //     return length + 1;
    // }

    public static void main(String[] args) {
        Solution solution = new Solution();
    
        int[] nums = {1, 2, 0};
        int result = solution.firstMissingPositive(nums);
        System.out.println("输出: " + result);
    }
}