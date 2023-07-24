import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    List<Integer> ans = new ArrayList<Integer>();
    List<Integer> cur = new ArrayList<Integer>();
    int count = 0;
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        Arrays.fill(used, false);
        dfs(n, k, used);
        StringBuilder sb = new StringBuilder();
        for (Integer item : ans) {
            sb.append(item);
        }
        return sb.toString();
    }

    public void dfs(int n, int k, boolean[] used) {
        if (cur.size() == n) {
            count++;
            if (count == k) {
                ans = new ArrayList<>(cur);
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            cur.add(i);
            used[i] = true;
            dfs(n, k, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int k = 9;
        String result = solution.getPermutation(n, k);
        System.out.println("Output: " + result);
    }
}