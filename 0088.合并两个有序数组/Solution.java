import java.util.Arrays;

class Solution {
    // 双指针法，从尾到头
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int locate = m + n - 1;
        int p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[locate] = nums1[p1];
                p1--;
            }
            else {
                nums1[locate] = nums2[p2];
                p2--;
            }
            locate--;
        }
        for (int i = p1; i >= 0; i--) {
            nums1[locate] = nums1[i];
            locate--;
        }
        for (int i = p2; i >= 0; i--) {
            nums1[locate] = nums2[i];
            locate--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println("Input nums1: " + Arrays.toString(nums1));
        System.out.println("Expected Output: [1, 2, 2, 3, 5, 6]");
    }
}