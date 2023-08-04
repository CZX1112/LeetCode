import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(false, 0, nums, temp, result);
        return result;
    }

    public void dfs(boolean choosePre, int cur, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 不选当前元素，choosePre为false
        dfs(false, cur + 1, nums, temp, result);
        // 判断是否与前一个元素相同且未选前一个元素，没选说明递归前一层已经选过了
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        // 选当前元素，choosePre为true
        temp.add(nums[cur]);
        dfs(true, cur + 1, nums, temp, result);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        System.out.println(subsets);
    }
}