import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(nums[cur]);
        dfs(res, temp, cur + 1, nums);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(res, temp, cur + 1, nums);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + result);
    }
}