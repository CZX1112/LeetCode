import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();
        oneList.add(1);
        result.add(oneList);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    temp.add(sum);
                }
            }
            result.add(temp);
        }
        return result.get(rowIndex);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> result = sol.getRow(3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}