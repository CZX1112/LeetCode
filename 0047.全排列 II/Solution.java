import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        if (length == 0) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        
        boolean[] used = new boolean[length];
        backtrack(nums, result, output, used, 0);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> output, boolean[] used, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)) {
                continue;
            }
            output.add(nums[i]);
            used[i] = true;
            backtrack(nums, result, output, used, idx + 1);
            // 回溯部分的代码，和 backtrack 之前的代码是对称的
            used[i] = false;
            output.remove(idx);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> permutations = solution.permuteUnique(nums);
        System.out.println(permutations);
    }
}