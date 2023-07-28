import java.util.Arrays;

class Solution {
    // 法一：单指针 两次遍历
    // public void sortColors(int[] nums) {
    //     int n = nums.length;
    //     int ptr = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (nums[i] == 0) {
    //             int temp = nums[i];
    //             nums[i] = nums[ptr];
    //             nums[ptr] = temp;
    //             ptr++;
    //         }
    //     }
    //     for (int i = ptr; i < n; i++) {
    //         if (nums[i] == 1) {
    //             int temp = nums[i];
    //             nums[i] = nums[ptr];
    //             nums[ptr] = temp;
    //             ptr++;
    //         }
    //     }
    // }

    // 法二：双指针 单次遍历，ptr0指头，ptr2指尾
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr0 = 0, ptr2 = n - 1;
        for (int i = 0; i <= ptr2; i++) {
            if (nums[i] == 2) {
                while (i <= ptr2 && nums[ptr2] == 2) {
                    ptr2--;
                }
                if (i <= ptr2) {
                    int temp = nums[i];
                    nums[i] = nums[ptr2];
                    nums[ptr2] = temp;
                    ptr2--;
                }
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr0];
                nums[ptr0] = temp;
                ptr0++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println("Input: " + Arrays.toString(nums));
        solution.sortColors(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }
}